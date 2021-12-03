package com.example.demo.controllers;

import com.example.demo.interfaces.IUser;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    IUser user;

    @PostMapping("/connexion")
    public User connexion(@RequestBody User u){
        return user.connectUser(u);
    }
}
