package com.homework.InsuranceApp.service;

import com.homework.InsuranceApp.model.User;
import com.homework.InsuranceApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{
    private final UserRepository userRepository;

    public List<User> findAll(){return userRepository.findAll();}
    public User createUser(User user){
        return userRepository.save(user);
    }

    public User removeUser(User user){
        return userRepository.remove(user);
    }

}
