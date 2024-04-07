package com.lesslsmore.music.service;

import com.lesslsmore.music.common.ScanType;
import com.lesslsmore.music.common.Utils;
import com.lesslsmore.music.config.Conf;
import com.lesslsmore.music.entity.Fold;
import com.lesslsmore.music.entity.Song;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ScanService {
    @Autowired
    private Conf conf;

    public List<Song> scanSongs(String path) throws IOException {
        List<Path> paths = Utils.scan(path, ScanType.Files);
        List<Song> songs = new ArrayList<>();
        paths.forEach(p -> {
            Song song = Song.builder()
                    .path(p.toString().replace('\\','/'))
                    .fold(p.getParent().toString().replace('\\','/'))
                    .file(p.getFileName().toString())
                    .build();
            try {
                Utils.get_meta_by_id3(song);
                String url = '/' + Paths.get(conf.base_path).relativize(Paths.get(song.getPath())).toString().replace('\\','/');
                log.info("url test {}", url);
                song.setUrl(url);
                songs.add(song);
            } catch (Exception e) {
                log.error("songService.save {}, {}", e, song);
            }
        });
        return songs;
    }

    public List<Fold> scanFolds(String path) throws IOException {
        List<Path> paths = Utils.scan(path, ScanType.Folds);
        List<Fold> folds = new ArrayList<>();
        paths.forEach(p -> {
            Fold fold = Fold.builder()
                    .path(p.toString().replace('\\','/'))
                    .fold(p.getParent().toString().replace('\\','/'))
                    .file(p.getFileName().toString())
                    .build();

            log.info("songService.save {}", fold);

            folds.add(fold);
        });
        return folds;
    }
}
