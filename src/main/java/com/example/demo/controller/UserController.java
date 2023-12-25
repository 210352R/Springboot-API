package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.WithdrowalRequestDto;
import com.example.demo.entity.Withdrowal;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getUsers")
    public List<UserDto> getUser(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/getUser/{userId}")
    public UserDto getUserById(@PathVariable int userId){
        return userService.getUserByID(userId);
    }

    @PostMapping(value = "/saveUser")
    public UserDto saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @PutMapping(value = "/updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    @DeleteMapping(value = "/deleteUser")
    public boolean deleteUser(@RequestParam int userId){
        return userService.deleteUserById(userId);
    }

    @PostMapping("/setWithdrowal")
    public Withdrowal doWithdrowal(@RequestBody WithdrowalRequestDto withdrowalRequestDto){
        System.out.println("Call Set withdrowal service method ------------ ");
        return userService.makeWithdrowal(withdrowalRequestDto);
    }
}
