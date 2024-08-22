package com.instagram.instgram.service;

import com.instagram.instgram.entity.Photo;
import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {
    Photo savePhoto(MultipartFile file, Long mainId);
}
