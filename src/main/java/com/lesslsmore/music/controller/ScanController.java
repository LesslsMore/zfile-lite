package com.lesslsmore.music.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.lesslsmore.music.common.result.Result;
import com.lesslsmore.music.config.Conf;
import com.lesslsmore.music.entity.Fold;
import com.lesslsmore.music.entity.Song;
import com.lesslsmore.music.service.FoldService;
import com.lesslsmore.music.service.ScanService;
import com.lesslsmore.music.service.SongService;

@RequestMapping("/scan")
@Slf4j
@RestController
public class ScanController {
    @Autowired
    public SongService songService;
    @Autowired
    public ScanService scanService;
    @Autowired
    public FoldService foldService;
    @Autowired
    public Conf conf;

    @PostMapping("/conf")
    public Result setConf(@RequestBody Conf c) {
        System.out.println(c);
        return Result.ok(c);
    }

    @PostMapping("/path/{*path}")
    public Result setPath(@PathVariable String path) {
        String ps = path.substring(1);
        Path p = Paths.get(ps);
        Fold fold = Fold.builder()
                .path(p.toString().replace('\\','/'))
                .fold(p.getParent().toString().replace('\\','/'))
                .file(p.getFileName().toString())
                .id(0)
                .build();
        log.info("fold = {}", fold);
        boolean save = foldService.saveOrUpdate(fold);
        return Result.ok(save);
    }

    @PostMapping("/song/{*path}")
    public Result scanSongs(@PathVariable String path) throws IOException {
        String p = path.substring(1);
        System.out.println(p);
        QueryWrapper<Fold> queryWrapper = new QueryWrapper<>();
        List<Fold> folds = foldService.list(queryWrapper.eq("path", p));

        QueryWrapper<Song> songQueryWrapper = new QueryWrapper<>();
        List<Song> songs = songService.list(songQueryWrapper.eq("fold",p));
        if (folds.size() > 0 && songs.size() == 0) {
            songs = scanService.scanSongs(folds.get(0).getPath());
            songService.saveBatch(songs);
        }
        return Result.ok(songs);
    }

    @PostMapping("/fold/{*path}")
    public Result foldList(@PathVariable String path) throws IOException {
        String p = path.substring(1);
        System.out.println(p);
        QueryWrapper<Fold> queryWrapper = new QueryWrapper<>();
        List<Fold> folds = foldService.list(queryWrapper.eq("fold", p));
        if (folds.size() == 0) {
            folds = scanService.scanFolds(p);
            foldService.saveBatch(folds);
        }
        return Result.ok(folds);
    }

}
