package com.mycompany.mvcproject.domain;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class User {
    // 미리 설정한 로그인 정보 : DB에 저장되어 있는 데이터라고 가정
    public static final String DEFAULT_EMAIL = "test@test.com";
    public static final String DEFAULT_PASSWORD = "pw1234";

    private int id; // DB의 primary key 역할
    private String name;
    private String email;
    private String password;
    private Integer age;

    public boolean login(){
        String email = this.getEmail();
        String password = this.getPassword();
        if(DEFAULT_EMAIL.equals(email) && DEFAULT_PASSWORD.equals(password)){
            return true;
        } else return false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

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
