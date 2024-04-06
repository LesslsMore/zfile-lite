package com.lesslsmore.music;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.lesslsmore.music.config.Conf;

@MapperScan("com.lesslsmore.music.mapper")
@SpringBootApplication
public class Application implements WebMvcConfigurer {
    @Autowired
    public Conf config;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // http://localhost:8088/music/2-Japanese/白色相簿/01. 幸せな記憶.mp3
        String base_path = "file:" + config.base_path;
        registry.addResourceHandler(config.map_url).addResourceLocations(base_path);
    }
}