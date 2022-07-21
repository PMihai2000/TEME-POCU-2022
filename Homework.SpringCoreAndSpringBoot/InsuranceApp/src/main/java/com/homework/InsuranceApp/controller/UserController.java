package com.homework.InsuranceApp.controller;

import com.homework.InsuranceApp.model.User;
import com.homework.InsuranceApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user){return userService.createUser(user);}
    @GetMapping("/details")
    public List<User> getUsers(){
        return userService.findAll();
    }
    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }
    @DeleteMapping("/remove/{id}")
    public User removeUserById(@PathVariable long id){
        return userService.removeUserById(id);
    }
}
