package com.lesslsmore.music;

import com.lesslsmore.music.common.ScanType;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static com.lesslsmore.music.common.Utils.scan;

public class scan_test {
    @Test
    public void scan_test0() throws IOException {
        String path = "E:\\T\\Music";
        List<Path> paths = scan(path, ScanType.All);
        System.out.println(paths);
    }
    @Test
    public void scan_test1() throws IOException {
        String path = "E:\\T\\Music";
        List<Path> paths = scan(path, ScanType.Files);
        System.out.println(paths);
    }
    @Test
    public void scan_test2() throws IOException {
        String path = "E:\\T\\Music";
        List<Path> paths = scan(path, ScanType.Folds);
        System.out.println(paths);
    }
}
