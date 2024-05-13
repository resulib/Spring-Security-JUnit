package com.resul.springsecuritycaptcha.service;

import com.resul.springsecuritycaptcha.auth.JwtService;
import com.resul.springsecuritycaptcha.dto.AuthenticationRequestDTO;
import com.resul.springsecuritycaptcha.dto.AuthenticationResponseDTO;
import com.resul.springsecuritycaptcha.dto.RegisterRequestDTO;
import com.resul.springsecuritycaptcha.entity.UserEntity;
import com.resul.springsecuritycaptcha.entity.UserRoleEnum;
import com.resul.springsecuritycaptcha.exception.UserAlreadyExistsException;
import com.resul.springsecuritycaptcha.exception.UserNotFoundException;
import com.resul.springsecuritycaptcha.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponseDTO register(RegisterRequestDTO requestDTO) {
        var userOptional = userRepository.findByUsername(requestDTO.getUsername());

        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException("Username already exists: " + requestDTO.getUsername());
        }

        var userEntity = createUser(requestDTO);
        var jwtToken = jwtService.generateToken(userEntity);
        return AuthenticationResponseDTO
                .builder().token(jwtToken).build();
    }

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO requestDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getUsername(), requestDTO.getPassword()));
        var user = userRepository.findByUsername(requestDTO.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User not found: " + requestDTO.getUsername()));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDTO
                .builder()
                .token(jwtToken).build();
    }

    private UserEntity createUser(RegisterRequestDTO requestDTO) {
        var user = new UserEntity();
        user.setUsername(requestDTO.getUsername());
        user.setEmail(requestDTO.getEmail());
        user.setUserRole(UserRoleEnum.USER);
        user.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        return userRepository.save(user);
    }
}
