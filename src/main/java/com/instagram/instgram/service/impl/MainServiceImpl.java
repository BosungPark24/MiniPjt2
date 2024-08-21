package com.instagram.instgram.service.impl;

import com.instagram.instgram.dto.MainDto;
import com.instagram.instgram.entity.Main;
import com.instagram.instgram.mapper.MainMapper;
import com.instagram.instgram.repository.MainRepository;
import com.instagram.instgram.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainServiceImpl extends MainService {
    @Autowired
    private MainRepository mainRepository;

    @Autowired
    private MainMapper mainMapper;


    @Override
    public List<MainDto> getAllPosts() {
        List<Main> posts = mainRepository.findAll();
        return posts.stream().map(mainMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public MainDto getPostById(Long id) {
        Main post = mainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
        return mainMapper.toDto(post);
    }

    @Override
    public MainDto createPost(MainDto mainDto) {
        Main post = mainMapper.toEntity(mainDto);
        Main savedPost = mainRepository.save(post);
        return mainMapper.toDto(savedPost);
    }
    @Override
    public MainDto updatePost(Long id, MainDto mainDto) {
        Main existingPost = mainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
        existingPost.setContents(mainDto.getContents());
        Main updatedPost = mainRepository.save(existingPost);
        return mainMapper.toDto(updatedPost);
    }

    @Override
    public void deletePost(Long id) {
        Main post = mainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
        mainRepository.delete(post);
    }
}
