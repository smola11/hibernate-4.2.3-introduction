package com.maciej.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private int total = 0;
    private int goal = 100;
}
