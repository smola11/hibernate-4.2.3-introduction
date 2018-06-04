package com.maciej.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {

    public User() {
        setProteinData(new ProteinData());
    }

    private Long id;
    private String name;
    private ProteinData proteinData;

    // We use interfaces like Set or List because hibernate will create own implementation;
    private List<UserHistory> history = new ArrayList<>();

    private GoalAlert goalAlert;


    public void addHistory(UserHistory historyItem) {
        // bidirectional relationship
        historyItem.setUser(this);
        history.add(historyItem);
    }

    public void setProteinData(ProteinData proteinData) {
        this.proteinData = proteinData;
        proteinData.setUser(this);
    }
}
