package com.example.restapi_ex.controller;

import com.example.restapi_ex.controller.model.UserRequest;
import com.example.restapi_ex.controller.model.UserResponse;
import com.example.restapi_ex.entity.UserEntity;
import com.example.restapi_ex.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // 생성자에서 autowire 주입
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // 생성
    @PostMapping
    public UserResponse create(@RequestBody UserRequest request) throws Exception{
        UserEntity entity =  userService.createUserWithRollBack(
                UserEntity.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .build()
        );

        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();

    }

    // 조회
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        UserEntity entity = userService.getUserById(id);

        if(entity == null) {return UserResponse.builder().build();}
        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();

    }

    // 업데이트
    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id, @RequestBody UserRequest request) {
        UserEntity entity = userService.getUserById(id);

        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();

    }

}
