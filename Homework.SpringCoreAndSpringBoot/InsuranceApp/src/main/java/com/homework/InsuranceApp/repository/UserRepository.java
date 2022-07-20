package com.homework.InsuranceApp.repository;

import com.homework.InsuranceApp.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();
    public List<User> findAll(){return users;}
    public User save(User user){
        users.add(user);
        return user;
    }

    public User remove(User user){
        users.remove(user);
        return user;
    }
}
