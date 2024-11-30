package com.example.catwiki.controller;

import com.example.catwiki.model.Cat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController // @Controller (bean 등록하는 어노테이션) + @ResponseBody 두 가지 기능 합친 어노테이션.
@RequestMapping("/cats")
public class CatController {

    private final List<Cat> catList = new ArrayList<Cat>();

    public CatController() {
        catList.add(new Cat(1L, "Milo", "Male", 3));
        catList.add(new Cat(2L, "Luna", "Female", 1));
        catList.add(new Cat(3L, "Leo", "Male", 8));
    }

    // 고양이 리스트 반환
    // http://localhost:8080/cats/
    @GetMapping
    public List<Cat> getAllCats(){
        return catList;
    }

    // 고양이 정보 조회
    // http://localhost:8080/cats/1
    // http://localhost:8080/cats/2 ...
    @GetMapping("/{id}") // pass variable
    public Cat getCatById(
            @PathVariable Long id){
//        for(Cat cat : catList){
//            if(cat.getId().equals(id)){
//                return cat;
//            }
//
//        }
        Optional<Cat> cat = catList.stream()
                .filter(c-> c.getId().equals(id))
                .findFirst(); // Optional로 받음. (null 일 수 있기 때문)

        return cat.orElse(null);
    }

    // 새 고양이 추가
    // http://localhost:8080/cats
    @PostMapping
    public Cat addCat(
            @RequestBody Cat cat){
        cat.setId(catList.size()+1L);
        catList.add(cat);
        return cat;
    }

    // 고양이 삭제
    @DeleteMapping("/{id}")
    public String deleteCat(@PathVariable Long id){
        for(Cat cat : catList){
            if(cat.getId().equals(id)){
                catList.remove(cat);
                return "(id: " + id + ") Cat removed";
            }
        }
        return "(id: " + id + ") Cat not found";
    }
}
