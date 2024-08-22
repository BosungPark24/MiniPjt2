package com.instagram.instgram.controller;

import com.instagram.instgram.dto.MainDto;
import com.instagram.instgram.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/main")
public class MainController {

    @Autowired
    private MainService mainService;

    // 모든 게시글 조회
    @GetMapping
    public List<MainDto> getAllPosts() {
        return mainService.getAllPosts();
    }

    // 특정 게시글 ID로 조회
    @GetMapping("/{id}")
    public MainDto getPostById(@PathVariable Long id) {
        return mainService.getPostById(id);
    }

    // 게시글 등록
    @PostMapping("/write")
    public MainDto createPost(@RequestBody MainDto mainDto) {
        return mainService.createPost(mainDto);
    }



    // 게시글 수정
    @PutMapping("/update/{id}")
    public MainDto updatePost(@PathVariable Long id, @RequestBody MainDto mainDto){
        return mainService.updatePost(id, mainDto);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public MainDto deletePost(@PathVariable Long id){
        mainService.deletePost(id);
        return null;
    }
}
