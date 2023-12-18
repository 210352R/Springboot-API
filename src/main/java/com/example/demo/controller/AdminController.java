package com.example.demo.controller;

import com.example.demo.dto.AdminDto;
import com.example.demo.dto.AdminWithUsersRequest;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserRequest;
import com.example.demo.entity.Admin;
import com.example.demo.entity.User;
import com.example.demo.service.AdminService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value= "api/v1/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/getAdmins")
    public String getUser(){
        return "Hello Admin Controller ----";
    }

//    @GetMapping(value = "/getAdmin/{adminId}")
//    public UserDto getUserById(@PathVariable int userId){
//
//    }
//
    @PostMapping(value = "/saveAdmin")
    public AdminDto saveUser(@RequestBody AdminDto adminDto){
        return adminService.saveAdmin(adminDto);
    }
//
//    @PutMapping(value = "/updateAdmin")
//    public UserDto updateUser(@RequestBody UserDto userDto){
//
//    }
//
//    @DeleteMapping(value = "/deleteAdmin")
//    public boolean deleteUser(@RequestParam int userId){
//
//    }



    @PostMapping("/add")
    public void addAdminWithUsers(@RequestBody AdminWithUsersRequest request) {
        // Create an Admin object
        Admin admin = new Admin();
        admin.setId(request.getAdminId());
        admin.setName(request.getAdminName());
        admin.setAddress(request.getAdminAddress());

        // Create a set of User objects
        Set<User> users = new HashSet<>();
        for (UserRequest userRequest : request.getUsers()) {
            User user = new User();
            user.setId(userRequest.getUserId());
            user.setName(userRequest.getUserName());
            user.setAddress(userRequest.getUserAddress());
            // Add the user to the set
            users.add(user);
        }

        // Call the service method to add admin with users
        adminService.addAdminWithUsers(admin, users);
    }


}
