package com.instagram.instgram.repository;

import com.instagram.instgram.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    // 특정 사용자의 사진 목록을 검색하는 메서드
    List<Photo> findByUserId(Long userId);
}
