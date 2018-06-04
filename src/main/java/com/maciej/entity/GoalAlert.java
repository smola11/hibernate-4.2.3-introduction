package com.maciej.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GoalAlert {

    public GoalAlert(String message) {
        this.message = message;
    }

    private Long id;
    private String message;
}
