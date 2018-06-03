package com.maciej.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private int total;
    private int goal;
}
