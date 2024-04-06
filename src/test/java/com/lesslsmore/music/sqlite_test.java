//package com.lesslsmore.music;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.lesslsmore.music.dao.song;
//import com.lesslsmore.music.entity.Song;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class sqlite_test {
////    @Autowired
////    private song.SongMapper songMapper;
//    @Test
//    public void test() {
////        String jsonString = "{file: '舞い落ちる雪のように', artist: 'Suara', url: 'file:///D:/T/Music/WA1/Suara%20-%20%E8%88%9E%E3%81%84%E8%90%BD%E3%81%A1%E3%82%8B%E9%9B%AA%E3%81%AE%E3%82%88%E3%81%86%E3%81%AB.mp3', cover: 'cover.jpg'}";
////        Song song = JSON.parseObject(jsonString, Song.class);
////        System.out.println("song lim: " + song);
//////        JSONObject jsonObject = JSON.parseObject(jsonString);
//////        System.out.println("song lim: " + jsonObject);
////        int insert = songMapper.insert(song);
////        System.out.println("insert : " + insert);
//////        Song song1 = songMapper.selectById(1);
//////        System.out.println("song1: " + song1);
////        if (insert > 0) {
////            System.out.println("insert succeed");
////        } else {
////            throw new RuntimeException("insert failed");
////        }
//        String jsonString = "{cid:1,file: '舞い落ちる雪のように', artist: 'Suara', url: 'file:///D:/T/Music/WA1/Suara%20-%20%E8%88%9E%E3%81%84%E8%90%BD%E3%81%A1%E3%82%8B%E9%9B%AA%E3%81%AE%E3%82%88%E3%81%86%E3%81%AB.mp3', cover: 'cover.jpg'}";
//        Song song = JSON.parseObject(jsonString, Song.class);
//        System.out.println("song lim: " + song);
//        JSONObject jsonObject = JSON.parseObject(jsonString);
//        System.out.println("song lim: " + jsonObject);
//        int insert = songMapper.insert(song);
//        System.out.println("insert : " + insert);
//        if (insert > 0) {
//            System.out.println("insert succeed");
//        } else {
//            throw new RuntimeException("insert failed");
//        }
//
//        QueryWrapper<Song> songQueryWrapper = new QueryWrapper<>();
//        Song song1 = songMapper.selectOne(songQueryWrapper.eq("cid", 2));
////        songMapper.selectList()
//        System.out.println("song1: " + song1);
//    }
//}
