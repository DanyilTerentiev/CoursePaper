package com.coursepaper.CoursePaper.services;

import com.coursepaper.CoursePaper.DTOs.RegisterRequest;
import com.coursepaper.CoursePaper.Entitities.Role;
import com.coursepaper.CoursePaper.Repositories.UserRepository;
import com.coursepaper.CoursePaper.jwt.JwtRequest;
import com.coursepaper.CoursePaper.jwt.JwtResponse;
import com.coursepaper.CoursePaper.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.coursepaper.CoursePaper.Entitities.User;
@Service
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public JwtResponse register(RegisterRequest request) {
        var user = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                Role.User
        );
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return new JwtResponse(jwtToken);
    }

    public JwtResponse authenticate(JwtRequest request) {
        var user = repository.findUserByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Username with such email was not found"));
        System.out.println(user);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var jwtToken = jwtService.generateToken(user);
        return new JwtResponse(jwtToken);
    }
}