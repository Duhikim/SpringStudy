package com.example.restfulboardservice.controller.model;

import com.example.restfulboardservice.entity.PostEntity;
import lombok.Data;

@Data
public class PostRequest {
    private Long id;

    private String title;
    private String content;
    private String author;

    public PostRequest(PostEntity postEntity) {
        this.id = postEntity.getId();
        this.title = postEntity.getTitle();
        this.content = postEntity.getContent();
        this.author = postEntity.getAuthor();
    }
}
