package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminWithUsersRequest {
    private int adminId;
    private String adminName;
    private String adminAddress;
    private Set<UserRequest> users;
}
