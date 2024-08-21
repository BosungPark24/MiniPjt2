package com.instagram.instgram.service;

import com.instagram.instgram.dto.MainDto;

import java.util.List;

public abstract class MainService {
    public abstract List<MainDto> getAllPosts();

    public abstract MainDto getPostById(Long id);

    public abstract MainDto createPost(MainDto mainDto);

    public MainDto updatePost(Long id, MainDto mainDto) {
        return null;
    }

    public void deletePost(Long id) {
    }
}
