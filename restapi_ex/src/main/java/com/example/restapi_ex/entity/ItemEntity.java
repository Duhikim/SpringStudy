package com.example.restapi_ex.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="item")
public class ItemEntity {

    @Id
    private String id;
    private String name;
}
