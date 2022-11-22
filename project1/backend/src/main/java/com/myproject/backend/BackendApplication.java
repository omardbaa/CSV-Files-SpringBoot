package com.myproject.backend;

import com.myproject.backend.entity.Role;
import com.myproject.backend.entity.User;
import com.myproject.backend.repository.RoleRepository;
import com.myproject.backend.repository.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.Set;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Book API", version = "2.0", description = "Book Information"))

public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
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


