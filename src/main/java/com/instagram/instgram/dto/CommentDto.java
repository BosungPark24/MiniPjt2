package com.instagram.instgram.dto;

import com.instagram.instgram.entity.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Getter
@Setter
public class CommentDto {
    private Long id;
    private String photoId;
    private String text;
    private String createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private int main;


}
