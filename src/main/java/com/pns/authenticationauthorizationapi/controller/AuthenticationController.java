package com.pns.authenticationauthorizationapi.controller;

import com.pns.authenticationauthorizationapi.model.AuthenticationResponse;
import com.pns.authenticationauthorizationapi.model.RegisterRequest;
import com.pns.authenticationauthorizationapi.service.AuthenticationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("admin")
    public String admin(){
        return "Admin";
    }

    @GetMapping("user")
    public String user(){
        return "User";
    }

}
