package com.example.restapi_ex.controller.model;

import lombok.*;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
// @Data로 아래 세 개 포함함
@Getter
@Setter
@ToString
public class ItemDto {
    private String id;
    private String name;
}
