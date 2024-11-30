package com.example.restapi_ex.controller.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class UserRequest {
    private String name;
    private String email;
}
