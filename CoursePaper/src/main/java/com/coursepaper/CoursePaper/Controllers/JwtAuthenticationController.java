package com.coursepaper.CoursePaper.Controllers;

import com.coursepaper.CoursePaper.DTOs.RegisterRequest;
import com.coursepaper.CoursePaper.jwt.JwtRequest;
import com.coursepaper.CoursePaper.jwt.JwtResponse;
import com.coursepaper.CoursePaper.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class JwtAuthenticationController {
    private final AuthenticationService service;

    public JwtAuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register (
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> authenticate (
            @RequestBody JwtRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
