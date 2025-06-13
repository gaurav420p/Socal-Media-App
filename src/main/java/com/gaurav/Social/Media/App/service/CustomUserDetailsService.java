package com.gaurav.Social.Media.App.service;

import com.gaurav.Social.Media.App.model.User;
import com.gaurav.Social.Media.App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(username);
        if(user==null){
            throw new  UsernameNotFoundException("user not found with email "+ username);
        }

        List<GrantedAuthority> authorities=new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }
}














//🧠 Purpose:
//
//Required by Spring Security.
//
//        During login, Spring uses this service to load user data from DB.
//
//Also useful if you later implement role-based access using GrantedAuthority.
//
