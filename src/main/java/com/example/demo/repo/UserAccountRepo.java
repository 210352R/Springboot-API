package com.example.demo.repo;

import com.example.demo.entity.Admin;
import com.example.demo.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, Long> {
    List<UserAccount> findByCreatedDateBefore(LocalDateTime createdDate);

}
