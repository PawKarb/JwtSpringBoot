package com.spring.jwt.react.app.service;

import com.spring.jwt.react.app.model.AppUser;
import com.spring.jwt.react.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByLogin(username);
        return new org.springframework.security.core.userdetails.User(user.getLogin(), String.valueOf(user.getPassword()), new ArrayList<>());
    }
}
