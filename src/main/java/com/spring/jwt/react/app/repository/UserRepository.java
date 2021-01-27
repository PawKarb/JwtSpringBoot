package com.spring.jwt.react.app.repository;

import com.spring.jwt.react.app.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByLogin(String login);
}
