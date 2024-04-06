package com.lesslsmore.music.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.lesslsmore.music.entity.Song;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import com.mpatric.mp3agic.InvalidDataException;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Utils {
    public static List<Path> scan(String scan_path, ScanType scanType) throws IOException {
        Path path = Paths.get(scan_path);
        List<Path> paths;

        try (Stream<Path> spath = Files.list(path)) {
            if (scanType.equals(ScanType.Folds)) {
                paths = spath.filter(Files::isDirectory)
                        .collect(Collectors.toList());
            } else if(scanType.equals(ScanType.Files)){
                paths = spath.filter(Files::isRegularFile)
                        .filter(p -> p.toString().endsWith(".mp3"))
                        .collect(Collectors.toList());
            } else {
                paths = spath.collect(Collectors.toList());
            }

        }
        return paths;
    }

    // {
    //     file: '舞い落ちる雪のように',
    //     artist: 'Suara',
    //     url: 'file:///D:/T/Music/WA1/Suara%20-%20%E8%88%9E%E3%81%84%E8%90%BD%E3%81%A1%E3%82%8B%E9%9B%AA%E3%81%AE%E3%82%88%E3%81%86%E3%81%AB.mp3',
    //     cover: 'cover.jpg'
    //   },
//    public static Song get_meta(String path) throws Exception {
//        InputStream input = new FileInputStream(new File(path));
//        Metadata metadata = new Metadata();
//        Mp3Parser parser = new Mp3Parser();
//        parser.parse(input, new org.apache.tika.sax.BodyContentHandler(), metadata, new ParseContext());
//        input.close();
////        System.out.println("Title: " + );
//////        System.out.println("Artist: " + metadata.get("xmpDM:artist"));
////        System.out.println("Composer: " + metadata.get("xmpDM:composer"));
////        System.out.println("Title: " + metadata.get("name"));
////        System.out.println(path);
////        System.out.println(config.local_path);
////        System.out.println(metadata);
////        System.out.println("Genre: " + metadata.get("xmpDM:genre"));
////        System.out.println("Duration: " + metadata.get("xmpDM:duration"));
////        System.out.println("Album: " + metadata.get("xmpDM:album"));
//        Song song = Song.builder()
//                .file(metadata.get("dc:name"))
//                .artist(metadata.get("xmpDM:artist"))
//                .build();
//        return song;
//    }

    public static void get_meta_by_id3(Song song) throws InvalidDataException, UnsupportedTagException, IOException {
        Mp3File mp3file = new Mp3File(song.getPath());
        if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            song.setName(id3v2Tag.getTitle());
            song.setArtist(id3v2Tag.getArtist());

//            System.out.println("Artist: " + id3v2Tag.getArtist());
//            System.out.println("Title: " + id3v2Tag.getName());
//            System.out.println("Album: " + id3v2Tag.getAlbum());
//            System.out.println("Lyrics: " + id3v2Tag.getLyrics());

//            System.out.println("Track: " + id3v2Tag.getTrack());
//            System.out.println("Year: " + id3v2Tag.getYear());
//            System.out.println("Genre: " + id3v2Tag.getGenre() + " (" + id3v2Tag.getGenreDescription() + ")");
//            System.out.println("Comment: " + id3v2Tag.getComment());

//            System.out.println("Composer: " + id3v2Tag.getComposer());
//            System.out.println("Publisher: " + id3v2Tag.getPublisher());
//            System.out.println("Original artist: " + id3v2Tag.getOriginalArtist());
//            System.out.println("Album artist: " + id3v2Tag.getAlbumArtist());
//            System.out.println("Copyright: " + id3v2Tag.getCopyright());
//            System.out.println("URL: " + id3v2Tag.getUrl());
//            System.out.println("Encoder: " + id3v2Tag.getEncoder());

//            song = Song.builder()
//                    .name(id3v2Tag.getName())
//                    .artist(id3v2Tag.getArtist())
//                    .build();

            song.setLrc(id3v2Tag.getLyrics());
            byte[] albumImageData = id3v2Tag.getAlbumImage();
            if (albumImageData != null) {
//                System.out.println("Have album image data, length: " + albumImageData.length + " bytes");
//                System.out.println("Album image mime type: " + id3v2Tag.getAlbumImageMimeType());
//                System.out.println(format);
                String s = Base64.getEncoder().encodeToString(albumImageData);
                String format = String.format("data:%s;base64,%s", id3v2Tag.getAlbumImageMimeType(), s);
                song.setCover(format);
            }
        } else {
            log.error("music tag is not Id3v2");
        }
    }
}
