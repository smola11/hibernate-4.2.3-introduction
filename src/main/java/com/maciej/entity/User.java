package com.maciej.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private ProteinData proteinData = new ProteinData();
}
