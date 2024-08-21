package com.instagram.instgram.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MainDto {
    private Long id;
    private String contents;
    private int likes = 0;
    private String createdAt;

}
