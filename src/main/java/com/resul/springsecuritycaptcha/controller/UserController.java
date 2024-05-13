package com.resul.springsecuritycaptcha.controller;

import com.resul.springsecuritycaptcha.dto.UserDTO;
import com.resul.springsecuritycaptcha.entity.UserEntity;
import com.resul.springsecuritycaptcha.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
}
