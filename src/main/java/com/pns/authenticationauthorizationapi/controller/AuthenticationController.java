package com.pns.authenticationauthorizationapi.controller;

import com.pns.authenticationauthorizationapi.model.AuthenticationRequest;
import com.pns.authenticationauthorizationapi.model.AuthenticationResponse;
import com.pns.authenticationauthorizationapi.model.ChangePasswordRequest;
import com.pns.authenticationauthorizationapi.model.RegisterRequest;
import com.pns.authenticationauthorizationapi.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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

    @PatchMapping("/password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest, Principal connectedUser){
        return ResponseEntity.ok(authenticationService.changePassword(changePasswordRequest,connectedUser));
    }
    @GetMapping("/logout")
    public void logout(){
        SecurityContextHolder.clearContext();
    }



}
