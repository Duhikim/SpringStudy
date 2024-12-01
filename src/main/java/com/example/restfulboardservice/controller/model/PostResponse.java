package com.example.restfulboardservice.controller.model;

import com.example.restfulboardservice.entity.PostEntity;

public class PostResponse {
    private Long id;

    private String title;
    private String content;
    private String author;

    public PostResponse(PostEntity postEntity) {
        this.id = postEntity.getId();
        this.title = postEntity.getTitle();
        this.content = postEntity.getContent();
        this.author = postEntity.getAuthor();
    }
}
