package org.example.cvbuilderapp.controllers;

import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.auth.AuthResponse;
import org.example.cvbuilderapp.dtos.auth.LoginRequest;
import org.example.cvbuilderapp.services.interfaces.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        // hapi 1: authenticate userin
        var user = authenticationService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        // hapi 2: generate jwt token
        var token = authenticationService.generateToken(user);

        var authResponse = new AuthResponse(token, 86400L); // 24 hours
        return  ResponseEntity.ok(authResponse);

    }
}
