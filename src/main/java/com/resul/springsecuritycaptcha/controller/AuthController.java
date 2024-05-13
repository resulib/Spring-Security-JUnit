package com.resul.springsecuritycaptcha.controller;

import com.resul.springsecuritycaptcha.dto.AuthenticationRequestDTO;
import com.resul.springsecuritycaptcha.dto.AuthenticationResponseDTO;
import com.resul.springsecuritycaptcha.dto.RegisterRequestDTO;
import com.resul.springsecuritycaptcha.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(requestDTO));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(@RequestBody AuthenticationRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.authenticate(requestDTO));
    }
}
