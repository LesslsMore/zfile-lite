package com.lesslsmore.music.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lesslsmore.music.common.result.Result;
import com.lesslsmore.music.entity.Fold;
import com.lesslsmore.music.entity.Song;
import com.lesslsmore.music.service.FoldService;
import com.lesslsmore.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListController {
    @Autowired
    public SongService songService;
    @Autowired
    public FoldService foldService;

    @PostMapping("/fold/{*path}")
    public Result foldList(@PathVariable String path) {
        String p = path.substring(1);
        System.out.println(p);
        QueryWrapper<Fold> queryWrapper = new QueryWrapper<>();
        List<Fold> foldList = foldService.list(queryWrapper.eq("fold", p));
        return Result.ok(foldList);
    }

    @PostMapping("/song/{*path}")
    public Result songList(@PathVariable String path) {
        String p = path.substring(1);
        System.out.println(p);
        QueryWrapper<Song> queryWrapper = new QueryWrapper<>();
        List<Song> songList = songService.list(queryWrapper.eq("fold", p));
        return Result.ok(songList);
    }
}
