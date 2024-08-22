package com.instagram.instgram.service.impl;

import com.instagram.instgram.entity.Main;
import com.instagram.instgram.entity.Photo;
import com.instagram.instgram.repository.MainRepository;
import com.instagram.instgram.repository.PhotoRepository;
import com.instagram.instgram.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private MainRepository mainRepository;

    private final String uploadDir = "uploads/"; // 파일을 임시로 저장할 디렉토리 경로

    @Override
    public Photo savePhoto(MultipartFile file, Long mainId) {
        try {
            // 파일을 서버에 저장 (여기서는 경로만 저장)
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());

            // Photo 엔티티 생성 및 저장
            Photo photo = new Photo();
            photo.setImageUrl(filePath.toString()); // 실제 파일 경로를 저장
            photo.setCaption(file.getOriginalFilename());

            // Main과 연결
            Main main = mainRepository.findById(mainId)
                    .orElseThrow(() -> new RuntimeException("Main post not found with id: " + mainId));
            photo.setMain(main);

            return photoRepository.save(photo);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }
}
