package com.instagram.instgram.service;

import com.instagram.instgram.dto.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto);
    CommentDto updateComment(Long id, CommentDto commentDto);
    void deleteComment(Long id);
    CommentDto getCommentById(Long id);
}
