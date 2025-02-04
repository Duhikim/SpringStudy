package com.hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // HTTP 응답 Body 부에 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // hellp XXXX 하고 그냥 글씨가 출력된다. 그런데 만약 객체를 반환하면 어떻게될까?
    }

    @GetMapping("hello-api")
    @ResponseBody // 객체를 생성해서 넣어주겠다.
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        hello.setAge(13);
        return hello; // JSON 방식으로 출력함.
    }

    static class Hello{
        private String name;
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
