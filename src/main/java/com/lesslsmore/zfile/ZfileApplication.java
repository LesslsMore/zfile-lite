package com.lesslsmore.zfile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.lesslsmore.zfile.core.filter"})
//@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
public class ZfileApplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(ZfileApplication.class, args);
    }
}