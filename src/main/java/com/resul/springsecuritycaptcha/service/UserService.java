package com.resul.springsecuritycaptcha.service;

import com.resul.springsecuritycaptcha.entity.UserEntity;
import com.resul.springsecuritycaptcha.repository.UserRepository;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> findAll() {
        var userList = userRepository.findAll();
        return userList;
    }
}
