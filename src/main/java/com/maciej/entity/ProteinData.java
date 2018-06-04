package com.maciej.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProteinData {

    private Long id;
    private int total;
    private int goal;
    private User user;
}
