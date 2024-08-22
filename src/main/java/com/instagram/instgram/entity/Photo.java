package com.instagram.instgram.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String imageUrl;
    private String caption;


    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    private Main main;
}
