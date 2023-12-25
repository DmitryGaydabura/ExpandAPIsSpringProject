package com.example.expandapisspringproject.controllers;

import com.example.expandapisspringproject.config.JwtUtil;
import com.example.expandapisspringproject.dao.pojo.User;
import com.example.expandapisspringproject.dto.AuthRequestDTO;
import com.example.expandapisspringproject.dto.AuthResponseDTO;
import com.example.expandapisspringproject.dto.UserDTO;
import com.example.expandapisspringproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user", produces = MediaType.TEXT_PLAIN_VALUE)
public class UserController {
    @Autowired
    private UserService userService;


    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok("User added successfully");
    }

    @PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequestDTO request) throws AuthenticationException {

        Boolean isAuth = userService.authenticate(request.getUsername(), request.getPassword());
        // If authentication was successful, proceed to create a token
        if (isAuth) {
            System.out.println("User OK");
            final String jwt = jwtUtil.generateToken(request.getName());
            System.out.println(jwt);
            return ResponseEntity.ok(new AuthResponseDTO(jwt));
        }
        System.out.println("No User");
        return ResponseEntity.notFound().build();
    }
}
