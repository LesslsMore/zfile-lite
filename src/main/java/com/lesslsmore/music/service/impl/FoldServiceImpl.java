package com.lesslsmore.music.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lesslsmore.music.entity.Fold;

import com.lesslsmore.music.mapper.FoldMapper;
import com.lesslsmore.music.service.FoldService;

import org.springframework.stereotype.Service;

@Service
public class FoldServiceImpl extends ServiceImpl<FoldMapper, Fold> implements FoldService {
}

