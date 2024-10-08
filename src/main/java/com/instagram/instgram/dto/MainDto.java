package com.instagram.instgram.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MainDto {
    private Long id;
    private String contents;
    private List<CommentDto> text;
    private List<PhotoDto> photos;
    private int likes = 0;
    private String createdAt;
}
