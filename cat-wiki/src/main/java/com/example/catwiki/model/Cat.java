package com.example.catwiki.model;

// 고양이 정보만 담는 모델
public class Cat {
    private Long id;
    private String name;
    private String gender;
    private int age;

    // 기본 생성자
    public Cat() {
    }
    // 생성자
    public Cat(Long id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    //Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{ " +
                "id = " + id +
                ", name = " + name +
                ", gender = " + gender +
                ", age = " + age +
                " } ";
    }
}
