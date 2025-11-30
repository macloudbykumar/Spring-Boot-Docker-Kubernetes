package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    public UserController(UserService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Users> create(@RequestBody Users user) {
        Users saved = service.create(user);
        return ResponseEntity.created(URI.create("/users/" + saved.getId()))
                             .body(saved);
    }

    @GetMapping
    public List<Users> list() {
        return service.list();
    }
}
