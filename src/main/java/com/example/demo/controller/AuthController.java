package com.example.demo.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.postgresmodel.User;
import com.example.demo.service.AuthService;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Register endpoint
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> userMap) {
        try {
            String name = userMap.get("name");
            String email = userMap.get("email");
            String password = userMap.get("password");

            User user = authService.register(name, email, password);

            return ResponseEntity.ok(Map.of(
                    "message", "User registered successfully",
                    "email", user.getEmail()
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginMap) {
        try {
            String email = loginMap.get("email");
            String password = loginMap.get("password");

            String token = authService.login(email, password);

            return ResponseEntity.ok(Map.of(
                    "token", token
            ));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
        }
    }
}
