package com.example.restfulboardservice.controller;

import com.example.restfulboardservice.controller.model.PostRequest;
import com.example.restfulboardservice.controller.model.PostResponse;
import com.example.restfulboardservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class Controller {
    private final PostService postService;

    @GetMapping
    public List<PostResponse> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostResponse getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @PostMapping
    public void createPost(@RequestBody PostRequest postRequest){
        postService.creatPost(postRequest);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostRequest postRequest){
        postService.updatePost(id, postRequest);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }

}
