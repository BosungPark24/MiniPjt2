package com.instagram.instgram.repository;

import com.instagram.instgram.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 특정 사진의 댓글 목록을 검색하는 메서드
    List<Comment> findByPhotoId(Long photoId);
}
