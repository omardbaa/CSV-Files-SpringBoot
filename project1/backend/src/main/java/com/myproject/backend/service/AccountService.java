package com.myproject.backend.service;

import com.myproject.backend.entity.Role;
import com.myproject.backend.entity.User;

public interface AccountService {
   User saveNewUser(Long id, String name, String username, String email, String password, String rePassword);
  Role saveNewRole (String name, String description);

    void addRoleToUser (String username, String roleName);
    void removeRoleToUser (String username, String roleName);

    User loadUserByUserName (String username);
}
