package com.example.restfulboardservice.model;

import lombok.Data;

import java.time.LocalDateTime;

// 게시판 글 정보만 담는 모델
@Data
public class Post {

    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;

    public Post() {
    }

    public Post(Long id, String title, String content, String author, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
    }
}
