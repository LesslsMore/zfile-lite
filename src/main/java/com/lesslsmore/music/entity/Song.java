package com.lesslsmore.music.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.SuperBuilder;

// {
//     file: '舞い落ちる雪のように',
//     artist: 'Suara',
//     url: 'file:///D:/T/Music/WA1/Suara%20-%20%E8%88%9E%E3%81%84%E8%90%BD%E3%81%A1%E3%82%8B%E9%9B%AA%E3%81%AE%E3%82%88%E3%81%86%E3%81%AB.mp3',
//     cover: 'cover.jpg'
//   },
@Data
@ToString(callSuper = true)
//@Document("page")
@SuperBuilder
//@AllArgsConstructor
@NoArgsConstructor
@TableName("songs")
public class Song extends Fold {
    public String name;   // aplayer 字段标题
    public String artist; // aplayer 字段

    public String url;
    public String lrc; // aplayer 字段
    public String cover;
//    public int cid;
}
