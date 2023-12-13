package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    public UserDto saveUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepo.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    public List<UserDto> getAllUsers(){
        List<User> userList  = userRepo.findAll();
        return modelMapper.map(userList , new TypeToken<List<UserDto>>(){}.getType());
    }

    public UserDto updateUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepo.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    public boolean deleteUserById (int userId){
       userRepo.deleteById(userId);
       return true;
    }


    public UserDto getUserByID(int Id){
        User user = userRepo.getUserById(Id);
        return modelMapper.map(user , UserDto.class);
    }




}
