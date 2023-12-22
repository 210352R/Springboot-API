package com.example.demo.repo;

import com.example.demo.entity.UserAccount;
import com.example.demo.entity.Withdrowal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WithdrowalRepo extends JpaRepository<Withdrowal, Long> {

}
