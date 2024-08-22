package com.instagram.instgram.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Main {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contents;
    private int likes = 0;

    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

    public Main(Long id, String contents, int likes) {
        this.contents = contents;

    }

    @OneToMany(mappedBy = "main", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("id asc")
    private List<Comment> text;

    @OneToMany(mappedBy = "main", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos;
}
