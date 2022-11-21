package com.myproject.backend.service;

import com.myproject.backend.entity.Role;
import com.myproject.backend.entity.User;
import com.myproject.backend.repository.RoleRepository;
import com.myproject.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@AllArgsConstructor
@Transactional

public class SecurityServiceImpl implements AccountService {


  @Autowired
    private UserRepository userRepositroy;


    private RoleRepository roleRepositroy;
    @Autowired
    public SecurityServiceImpl(RoleRepository roleRepositroy) {
        this.roleRepositroy = roleRepositroy;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveNewUser(Long id, String name, String username, String email, String password, String rePassword) {
        if(!password.equals(rePassword)) throw new RuntimeException("Password not match") ;

        String hashedPWD=passwordEncoder.encode(password);
        User user= new User();
        user.setEmail(email);
        user.setId(id);
        user.setUsername(username);
        user.setName(name);
        user.setPassword(hashedPWD);

        User savedAppUser= userRepositroy.save(user);
        return savedAppUser;
    }

    @Override
    public Role saveNewRole(String roleName, String description) {
        Role role= roleRepositroy.findByName(roleName);

        if(role!=null) throw new RuntimeException("Role "+roleName+ " already exist");

        role=new Role();
        role.setName(roleName);

        Role savedAppRole= roleRepositroy.save(role);

        return savedAppRole;
    }


    @Override
    public void addRoleToUser(String username, String roleName) {
        User user=userRepositroy.findByUsername(username);
        if(user==null) throw new RuntimeException("User not found");
        Role role= roleRepositroy.findByName(roleName);
        if(role==null) throw new RuntimeException("Role not found");
        user.getRoles().add(role);


    }

    @Override
    public void removeRoleToUser(String username, String roleName) {
       User appUser=userRepositroy.findByUsername(username);
        if(appUser==null) throw new RuntimeException("User not found");
        Role appRole= roleRepositroy.findByName(roleName);
        if(appRole==null) throw new RuntimeException("Role not found");
        appUser.getRoles().remove(appRole);

    }

    @Override
    public User loadUserByUserName(String username) {
        return userRepositroy.findByUsername(username);
    }

}