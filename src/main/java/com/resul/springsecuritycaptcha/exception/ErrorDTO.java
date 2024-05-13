package com.resul.springsecuritycaptcha.exception;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NotNull
public class ErrorDTO {
    private String message;
    private LocalDateTime timestamp;
}
