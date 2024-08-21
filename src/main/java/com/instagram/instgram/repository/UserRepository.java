package com.instagram.instgram.repository;

import com.instagram.instgram.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // 추가적으로 사용자 이름으로 검색하는 메서드
    User findByUsername(String username);
}
