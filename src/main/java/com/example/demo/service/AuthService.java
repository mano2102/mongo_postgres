package com.example.demo.service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.constants.Role;
import com.example.demo.model.postgresmodel.User;
import com.example.demo.repository.postgres.UserRepository;
import com.example.demo.utils.JwtUtils;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtils jwtUtils,
                       AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    // Register new user
    public User register(String name, String email, String password) throws Exception {
        if (userRepository.existsByEmail(email)) {
            throw new Exception("Email is already in use");
        }
        User user = User.builder()
                .name(name)
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(Role.ROLE_CUSTOMER)  
                .build();
        return userRepository.save(user);
    }

    // Login and generate JWT token
    public String login(String email, String password) throws Exception {
        // Authenticate user credentials
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        // Fetch user to create JWT
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("User not found"));

        // Generate token using email as subject
        return jwtUtils.generateToken(user.getEmail());
    }
}
