package com.instagram.instgram.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PhotoDto {

    private Long id;
    private String userId;
    private String imageUrl;
    private String caption;
    private LocalDateTime createdAt;
}
