package com.instagram.instgram.controller;

import com.instagram.instgram.dto.PhotoDto;
import com.instagram.instgram.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping("/upload")
    public PhotoDto uploadPhoto(@RequestParam("file") MultipartFile file,
                                @RequestParam("mainId") Long mainId,
                                @RequestParam("userId") String userId,
                                @RequestParam("caption") String caption) {
        return photoService.uploadPhoto(file, mainId, userId, caption);
    }
}
