package com.pns.authenticationauthorizationapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {
    @GetMapping
    public ResponseEntity<String> test (){
        return ResponseEntity.ok("Works?");
    }
    @GetMapping("/admin")
    public  ResponseEntity<String> admin(){
        return ResponseEntity.ok("Hello from admin");
    }

    @GetMapping("/user")
    public  ResponseEntity<String> user(){
        return ResponseEntity.ok("Hello from user");
    }

}
