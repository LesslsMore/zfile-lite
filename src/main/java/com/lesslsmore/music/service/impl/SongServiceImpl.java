package com.lesslsmore.music.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lesslsmore.music.mapper.SongMapper;
import com.lesslsmore.music.entity.Song;
import com.lesslsmore.music.service.SongService;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements SongService {
}

