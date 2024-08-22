package com.instagram.instgram.dto.mapper;

import com.instagram.instgram.dto.CommentDto;
import com.instagram.instgram.entity.Comment;
import com.instagram.instgram.entity.Main;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CommentMapper {

    public CommentDto toDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setPhotoId(comment.getPhotoId());
        dto.setText(comment.getText());
        dto.setCreatedAt(comment.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm")));
        dto.setMain(comment.getMain().getId().intValue());
        return dto;
    }

    public Comment toEntity(CommentDto dto, Main main) {
        Comment comment = new Comment();
        comment.setId(dto.getId());
        comment.setPhotoId(dto.getPhotoId());
        comment.setText(dto.getText());
        comment.setCreatedAt(LocalDateTime.parse(dto.getCreatedAt(), DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm")));
        comment.setMain(main);
        return comment;
    }
}
