package com.lesslsmore.zfile;

import com.lesslsmore.zfile.module.storage.model.entity.StorageSource;
import com.lesslsmore.zfile.module.storage.service.StorageSourceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
public class sqlite {
    @Autowired
    StorageSourceService storageSourceService;
    @Test
    public void test() throws IOException {
        List<StorageSource> storageList = storageSourceService.findAllEnableOrderByOrderNum();
        System.out.println("storageList = " + storageList);
    }
}
