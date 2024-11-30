package com.example.restapi_ex.service;

import com.example.restapi_ex.entity.UserEntity;
import com.example.restapi_ex.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor // 생성자에서 Autowire 해줌
@Service
public class UserService {
    private final UserRepository userRepository;

    // user 생성
    @Transactional
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public UserEntity createUserWithRollBack(UserEntity user) throws Exception{
        UserEntity entity = userRepository.save(user);

        // 강제 예외 발생
        if(user.getEmail().contains("error")){
            throw new Exception("강제 예외 발생!!");
        }

        return entity;
    }

    // user 정보 조회
    @Transactional(readOnly=true)
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // user 정보 수정
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    public UserEntity updateUser(Long id, UserEntity user) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        return userRepository.save(userEntity);
    }

}
