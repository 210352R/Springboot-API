package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository <User,Integer> {

    @Query(value = "select * from user where id = ?1" , nativeQuery = true)
    User getUserById(int ID);

}
