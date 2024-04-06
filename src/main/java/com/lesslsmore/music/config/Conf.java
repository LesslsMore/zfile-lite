package com.lesslsmore.music.config;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@ToString(callSuper = true)
//@Document("page")
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@TableName("conf")
@Component
@Configuration
public class Conf {
    @Value("${music.base_path}")
    public String base_path;
    @Value("${music.scan_path}")
    public String scan_path;
    @Value("${music.map_url}")
    public String map_url;
    @Value("${music.base_url}")
    public String base_url;

}
