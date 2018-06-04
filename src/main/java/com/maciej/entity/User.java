package com.maciej.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private ProteinData proteinData = new ProteinData();

    // We use interfaces like Set or List because hibernate will create own implementation;
    private Set<UserHistory> history = new HashSet<>();
}
