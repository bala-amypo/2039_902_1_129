package com.example.demo.controller;

import com.example.demo.service.impl.AuthServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthServiceImpl authService;

    public AuthController(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password) {
        return authService.login(email, password);
    }
}
