package com.example.restapi_ex.controller;

import com.example.restapi_ex.controller.model.ItemDto;
import com.example.restapi_ex.controller.model.ResponseDto;
import com.example.restapi_ex.service.RestExService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RestExController {

    private final RestExService restExService;

    // http://localhost:8080/test
    @GetMapping("/test")
    public String test() {
        log.info("test");
        return "{}";
    }

    // http://localhost:8080/test2
    @GetMapping("/test2")
    public String test2() {
        log.error("test2");
        return "test2";
    }

    @PostMapping("/item")
    public ResponseDto testRequestBody(@RequestBody ItemDto itemDto) {
        log.info("item: " + itemDto);

        boolean b = restExService.registerItem(itemDto);
        if(b){
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("OK");
            return responseDto;
        }
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("ERROR");
        return responseDto;
    }
}
