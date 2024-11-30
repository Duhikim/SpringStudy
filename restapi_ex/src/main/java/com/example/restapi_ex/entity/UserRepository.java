package com.example.restapi_ex.entity;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository에서 반환되는 UserEntity 값이 Optional 일 수 있다. Optional<UserEntity>
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
