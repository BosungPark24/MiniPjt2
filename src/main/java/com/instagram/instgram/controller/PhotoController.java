package com.instagram.instgram.controller;

import com.instagram.instgram.entity.Photo;
import com.instagram.instgram.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {
    @Autowired
    private PhotoRepository photoRepository;

    @PostMapping
    public Photo uploadPhoto(@RequestParam("file") MultipartFile file,
                             @RequestParam("userId") String userId,
                             @RequestParam("caption") String caption) {

        // 파일의 이름을 가져옴
        String fileName = file.getOriginalFilename();

        // Photo 엔티티를 생성하여 데이터베이스에 저장
        Photo photo = new Photo();
        photo.setUserId(userId);
        photo.setImageUrl(fileName);  // 여기서는 파일 이름만 저장
        photo.setCaption(caption);
        photo.setCreatedAt(LocalDateTime.now());

        // PhotoRepository를 사용해 데이터베이스에 저장
        return photoRepository.save(photo);
    }
}
