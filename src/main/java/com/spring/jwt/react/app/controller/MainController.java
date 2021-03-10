package com.spring.jwt.react.app.controller;

import com.spring.jwt.react.app.model.AuthRequest;
import com.spring.jwt.react.app.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/api")
    public String api(){
        return "Witaj na stronie api";
    }

    @GetMapping("/api/user")
    public String userApi(){
        return "Witaj na stronie User";
    }

    @GetMapping("/api/admin")
    public String adminApi(){
        return "Witaj na stronie Admin";
    }

    @PostMapping("/api/login")
    public Map generateToken(@RequestBody AuthRequest authRequest, HttpServletResponse response) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return Collections.singletonMap("token",jwtUtil.generateToken(authRequest.getUserName()));
    }

}
