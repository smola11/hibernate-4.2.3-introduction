package com.maciej.entity;

import lombok.*;

import java.util.Date;

@Data
public class UserHistory {

    private Date entryTime;
    private String entry;
}
