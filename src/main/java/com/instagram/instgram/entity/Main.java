package com.instagram.instgram.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Main {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contents;
    private int likes = 0;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Main(Long id, String contents, int likes) {
        this.contents = contents;
        this.createdAt = LocalDateTime.now();
    }
}
