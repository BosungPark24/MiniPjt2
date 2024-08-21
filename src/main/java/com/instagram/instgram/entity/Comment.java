package com.instagram.instgram.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "photo_id", nullable = false)
    private Photo photo;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String text;
    private LocalDateTime createdAt = LocalDateTime.now();
}
