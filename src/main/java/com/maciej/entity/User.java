package com.maciej.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private Set<GoalAlert> goalAlerts = new HashSet<>();


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
