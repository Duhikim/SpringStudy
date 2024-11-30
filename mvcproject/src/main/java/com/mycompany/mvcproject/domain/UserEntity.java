package com.mycompany.mvcproject.domain;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class UserEntity {
    // 미리 설정한 로그인 정보 : DB에 저장되어 있는 데이터라고 가정
    public static final String DEFAULT_EMAIL = "test@test.com";
    public static final String DEFAULT_PASSWORD = "pw1234";

    private int id; // DB의 primary key 역할
    private String name;
    private String email;
    private String password;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
