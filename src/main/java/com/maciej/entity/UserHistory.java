package com.maciej.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserHistory {

    public UserHistory(Date entryTime, String entry) {
        this.entryTime = entryTime;
        this.entry = entry;
    }

    private Long id;
    private User user;
    private Date entryTime;
    private String entry;
}
