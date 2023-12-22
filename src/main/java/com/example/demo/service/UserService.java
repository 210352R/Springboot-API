package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAccount;
import com.example.demo.repo.UserAccountRepo;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;



    @Autowired
    private UserAccountRepo userAccountRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public UserDto saveUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepo.save(user);
        LocalDateTime curr_dateTime = LocalDateTime.now();
        UserAccount userAccount = new UserAccount(savedUser, curr_dateTime , BigDecimal.ZERO , BigDecimal.ZERO,"Active");
        userAccountRepo.save(userAccount);
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

    @Transactional
//    @Scheduled(cron = "0 0 0 * * ?") // Run every day at midnight
    @Scheduled(fixedRate = 4000)
    public void increaseTotalAmount() {
        System.out.println("Sheduled task is working ######################################################################");
//        LocalDateTime threeDaysAgo = LocalDateTime.now().minus(3, ChronoUnit.DAYS);
//
//        // Find accounts created more than 3 days ago
//        userAccountRepo.findByCreatedDateBefore(threeDaysAgo).forEach(account -> {
//            // Increase totalAmount by 3 every day
//            BigDecimal increasedAmount = account.getTotal_amount().add(BigDecimal.valueOf(3));
//            account.setTotal_amount(increasedAmount);
//            userAccountRepo.save(account);
//        });
                // Find accounts created more than 3 days ago
//        userAccountRepo.findAll().forEach(account -> {
//            // Increase totalAmount by 3 every day
//            BigDecimal increasedAmount = account.getTotal_amount().add(BigDecimal.valueOf(3));
//            account.setTotal_amount(increasedAmount);
//            userAccountRepo.save(account);
//        });

    }
}
