package com.myproject.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountService securityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.myproject.backend.entity.User appUser = securityService.loadUserByUserName(username);

/*
Collection<GrantedAuthority> authorities=new ArrayList();
appUser.getAppRoles().forEach(role-> {

	SimpleGrantedAuthority authority=new SimpleGrantedAuthority(role.getRoleName());
    authorities.add(authority);
});*/

        Collection<GrantedAuthority> authorities =
                appUser.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList());

        User user = new User(appUser.getUsername(), appUser.getPassword(), authorities);
        return user;
    }

}