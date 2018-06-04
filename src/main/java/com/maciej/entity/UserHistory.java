package com.maciej.entity;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHistory {

    private Date entryTime;
    private String entry;
}
