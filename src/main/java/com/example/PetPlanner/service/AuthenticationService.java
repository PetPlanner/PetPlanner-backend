package com.example.PetPlanner.service;

import com.example.PetPlanner.config.JwtService;
import com.example.PetPlanner.dto.AuthRequest;
import com.example.PetPlanner.dto.AuthenticationResponse;
import com.example.PetPlanner.dto.RegisterRequest;
import com.example.PetPlanner.model.User;
import com.example.PetPlanner.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public void register(RegisterRequest request) {

        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .role(request.getRole())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);
    }

    public AuthenticationResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        HashMap claims = new HashMap<>();
        claims.put("id",user.getId());
        claims.put("role",user.getRole());
        var jwtToken = jwtService.generateToken(claims,user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
