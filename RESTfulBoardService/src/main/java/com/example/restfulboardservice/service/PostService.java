package com.example.restfulboardservice.service;

import com.example.restfulboardservice.controller.model.PostRequest;
import com.example.restfulboardservice.controller.model.PostResponse;
import com.example.restfulboardservice.entity.PostEntity;
import com.example.restfulboardservice.entity.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostResponse> getAllPosts() {
        List<PostEntity> posts = postRepository.findAll();
        return posts.stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    //getPostById
    public PostResponse getPostById(Long id) {
        PostEntity post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        // assert post != null; // IntelliJ가 자동으로 만들어줌. post == null이면 에러발생시키는 코드인 듯.
        return new PostResponse(post);
    }

    //creatPost
    public void createPost(PostRequest postRequest){
        PostEntity post = new PostEntity(postRequest.getTitle(), postRequest.getContent(), postRequest.getAuthor());
        postRepository.save(post); // 이 부분이 어떻게 동작하는지 궁금하다.
    }

    //updatePost
    public void updatePost(Long id, PostRequest postRequest){
        PostEntity post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setAuthor(postRequest.getAuthor());
        postRepository.save(post);
    }

    //deletePost
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
