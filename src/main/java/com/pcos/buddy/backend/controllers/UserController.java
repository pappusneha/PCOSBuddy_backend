package com.pcos.buddy.backend.controllers;


import com.pcos.buddy.backend.model.User;
import com.pcos.buddy.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(@RequestHeader("X-API-KEY") String apiKey) {
        return ResponseEntity.ok(userService.getUserFromToken(apiKey));
    }


}
