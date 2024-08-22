package com.instagram.instgram.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String photoId;
    private String userId;
    private String text;

    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    private Main main;
}
