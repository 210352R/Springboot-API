package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActivityLogRequestDto {
    // admin id
    private int adminId;

    // Transaction id
    private Long trans_id;

    // must be less than 10 characters------
    private String state;

    // comment
    private String comment;

    public ActivityLogRequestDto(int adminId, Long trans_id, String state) {
        this.adminId = adminId;
        this.trans_id = trans_id;
        this.state = state;
    }
}
