package com.lesslsmore.music;

import com.lesslsmore.music.config.Conf;
import com.lesslsmore.music.service.ScanService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest
public class scan_service_test {
    @Autowired
    public ScanService scanService;
    @Autowired
    public Conf conf;
    @Test
    public void scanSongs_test() throws IOException {
        try {
            scanService.scanSongs("E:/T/Music/WA1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void scanFolds_test() throws IOException {
        try {
            scanService.scanFolds("E:/T/Music");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
