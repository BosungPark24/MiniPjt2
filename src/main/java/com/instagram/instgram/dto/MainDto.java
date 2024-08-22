package com.instagram.instgram.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class MainDto {
    private Long id;
    private String contents;
    private List<CommentDto> text;
    private List<PhotoDto> photos;
    private int likes = 0;
    private String createdAt;


    public String getUserId() {
        return "";
    }

    public String getCaption() {
        return "";
    }
}
