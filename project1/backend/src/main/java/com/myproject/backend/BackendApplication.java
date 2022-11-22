package com.myproject.backend;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Random;
import java.util.Set;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Book API", version = "2.0", description = "Book Information"))

public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}



	@Bean
	PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}





	}


	/*	roleRepository.findAll().forEach(c->{


			User p=new User();
			p.setName(RandomString.make(18));
			p.setPassword(RandomString.make(5));
			p.setEmail(RandomString.make(10)+"@test.com");
			p.setUsername(RandomString.make(5));



			 userRepository.save(p);


		});*/


