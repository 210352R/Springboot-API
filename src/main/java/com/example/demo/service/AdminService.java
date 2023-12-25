package com.example.demo.service;


import com.example.demo.dto.AdminDto;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Note;
import com.example.demo.entity.User;
import com.example.demo.repo.AdminRepo;
import com.example.demo.repo.NoteRepo;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private NoteRepo noteRepo;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public AdminDto saveAdmin(AdminDto adminDto) {
        Admin admin = modelMapper.map(adminDto, Admin.class);
        Admin savedAdmin = adminRepo.save(admin);
        return modelMapper.map(savedAdmin, AdminDto.class);
    }

    public List<AdminDto> getAllAdmins(){
        List<Admin> adminList  = adminRepo.findAll();
        return modelMapper.map(adminList , new TypeToken<List<AdminDto>>(){}.getType());
    }

//    public UserDto updateUser(UserDto userDto) {
//        User user = modelMapper.map(userDto, User.class);
//        User savedUser = userRepo.save(user);
//        return modelMapper.map(savedUser, UserDto.class);
//    }
//
//    public boolean deleteUserById (int userId){
//        userRepo.deleteById(userId);
//        return true;
//    }

    @Transactional
    public void addAdminWithUsers(Admin admin, Set<User> users) {
        // Save the admin
        adminRepo.save(admin);

        // Set the admin for each user and save them
        for (User user : users) {
            user.setAdmin(admin);
            userRepo.save(user);
        }

        // Set the user list for the admin and update
        admin.setUserList(users);
        adminRepo.save(admin);
//        Note note = noteRepo.save(new Note(admin,"Added Note - "+admin.getId()));
    }

    public void addUser(User user , int admin_id){
        Admin admin = adminRepo.findById(admin_id).orElseThrow();
        Set<User> userList = admin.getUserList();
        userList.add(user);
        user.setAdmin(admin);
        userRepo.save(user);
        admin.setUserList(userList);


//        if (optionalAdmin.isPresent()) {
//            Admin admin = optionalAdmin.get();
//            // Perform operations with the retrieved Admin entity
//
//            Set<User> userList = admin.getUserList();
//            userList.add(user);
//            admin.setUserList(userList);
//        } else {
//            // Handle the case where the Admin entity was not found
//
//        }
    }


    public void addActivityLog(){

    }








}
