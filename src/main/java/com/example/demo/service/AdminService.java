package com.example.demo.service;


import com.example.demo.dto.ActivityLogRequestDto;
import com.example.demo.dto.AdminDto;
import com.example.demo.entity.*;
import com.example.demo.repo.*;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    private WithdrowalRepo withdrowalRepo;

    @Autowired
    private ActivityLogRepo activityLogRepo;

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


    @Transactional
    public ActivityLog addActivityLog(ActivityLogRequestDto activityLogRequestDto){
        int adminId = activityLogRequestDto.getAdminId();
        Long trans_id = activityLogRequestDto.getTrans_id();
        String state = activityLogRequestDto.getState();
        String comment = activityLogRequestDto.getComment();
        LocalDateTime curr_dateTime = LocalDateTime.now();

        System.out.println("-------------*** Admin ID = "+adminId);
        Admin admin = adminRepo.findById(adminId).orElseThrow();
        Withdrowal withdrowal = withdrowalRepo.findById(trans_id).orElseThrow();
        ActivityLog activityLog = new ActivityLog(admin,withdrowal,curr_dateTime , state ,comment);
        ActivityLog savedActivityLog = activityLogRepo.save(activityLog);

        // update transaction (Withdrowal)
        if(savedActivityLog.getState().equalsIgnoreCase("Ok")){
            withdrowal.setActivityLog(savedActivityLog);
            withdrowal.setGetDate(savedActivityLog.getDate());
            withdrowal.setStatus("Active");
        }
        else{
            System.out.println("There is Failed Activity Log");
        }
        return savedActivityLog;
    }








}
