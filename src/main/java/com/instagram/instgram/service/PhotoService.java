package com.instagram.instgram.service;

import com.instagram.instgram.dto.PhotoDto;
import com.instagram.instgram.entity.Photo;
import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {
    PhotoDto uploadPhoto(MultipartFile file, Long mainId, String userId, String caption);
}
