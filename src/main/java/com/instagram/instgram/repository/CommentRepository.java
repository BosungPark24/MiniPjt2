package com.instagram.instgram.repository;

import com.instagram.instgram.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByMainId(Long mainId); // Main ID로 댓글 조회
}
