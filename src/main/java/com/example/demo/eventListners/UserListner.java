package com.example.demo.eventListners;

import com.example.demo.entity.User;
import com.example.demo.entity.UserAccount;
import com.example.demo.repo.UserAccountRepo;
import jakarta.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class UserListner  {

    @Autowired
    private UserAccountRepo userAccountRepo;


    @PrePersist
    public void prePersist(User user) {
        System.out.println("Before persisting User with ID ---------------------------------------  : " + user.getId());
//        Note noteTemp = new Note(admin,"Added Note - "+admin.getId());
//        Note note = noteRepo.save(noteTemp)

          LocalDateTime curr_dateTime = LocalDateTime.now();
        UserAccount userAccount = new UserAccount(user, curr_dateTime , BigDecimal.ZERO , BigDecimal.ZERO,"Active");

        System.out.println("jhdfhfhfhkfdjfdjkfd  *********** "+userAccountRepo);
         //userAccountRepo.save(userAccount);
        System.out.println("After Operation  ---------------------------------------  : " + user.getId());
        // Perform actions before the entity is persisted to the database
    }

}
