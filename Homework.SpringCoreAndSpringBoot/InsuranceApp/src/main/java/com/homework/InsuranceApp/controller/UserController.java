package com.homework.InsuranceApp.controller;

import com.homework.InsuranceApp.model.User;
import com.homework.InsuranceApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User createUser(@Valid @RequestBody User user){return userService.createUser(user);}
    @GetMapping
    public List<User> getUsers(){
        return userService.findAll();
    }
}
