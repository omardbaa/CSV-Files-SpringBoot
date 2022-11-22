package com.myproject.backend.controller;

import com.myproject.backend.entity.User;
import com.myproject.backend.service.AccountService;
import com.myproject.backend.service.SecurityServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/user")
@Tag(name = "user", description = "all endpoints ")
public class UserController {


   /* private SecurityServiceImpl service;
    @Autowired
    public UserController(SecurityServiceImpl service) {
        this.service = service;
    }


    @PostMapping("/register")
    public User register(@RequestBody User user, Long id, String name, String username, String email, String password, String rePassword) {
        System.out.println(user);
        service.saveNewUser(id,name, username, email, password, rePassword);
        return user;
    }
*/
}
