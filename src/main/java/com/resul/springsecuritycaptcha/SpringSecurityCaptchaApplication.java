package com.resul.springsecuritycaptcha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@EnableMethodSecurity
@SpringBootApplication
public class SpringSecurityCaptchaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityCaptchaApplication.class, args);
    }

}
