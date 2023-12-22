package com.example.demo;

import com.example.demo.entity.Admin;
import com.example.demo.entity.User;
import com.example.demo.eventListners.UserListner;
import com.example.demo.repo.UserAccountRepo;
import com.example.demo.service.AdminService;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EntityScan(basePackages = "com.example.demo.entity")
@EnableJpaRepositories(basePackages = "com.example.demo.repo")
@ComponentScan(basePackages = "com.example.demo.eventListners")
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Bean
	public ModelMapper modelMapper(){
		return  new ModelMapper();
	}

//	@Bean
//	public UserListner userListner(UserAccountRepo userAccountRepo) {
//		UserListner userListner = new UserListner();
//		userListner.setUserAccountRepo(userAccountRepo);
//		return userListner;
//	}
}
