package com.example.demo;

import com.example.demo.entity.Admin;
import com.example.demo.entity.User;
import com.example.demo.service.AdminService;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Bean
	public ModelMapper modelMapper(){
		return  new ModelMapper();
	}
}
