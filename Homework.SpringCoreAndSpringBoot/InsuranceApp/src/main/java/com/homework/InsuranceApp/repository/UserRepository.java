package com.homework.InsuranceApp.repository;

import com.homework.InsuranceApp.exception.UserNotFoundException;
import com.homework.InsuranceApp.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
    public List<User> findAll(){return users;}
    public User save(User user){
        if(!users.contains(user)) {
            users.add(user);
        }else{
            throw new IllegalArgumentException("An user with id "+user.getId()+" already exists.");
        }
        return user;
    }

    public User remove(long id){
        try {
            User userToBeRemoved = users.stream()
                    .filter((u) -> u.getId() == id)
                    .findFirst()
                    .get();

            users.remove(userToBeRemoved);
            return userToBeRemoved;

        }catch(NoSuchElementException e){
            throw new UserNotFoundException("There's no user with id "+id+".");
        }
    }
    public User get(long id){
        try {
            return users.stream()
                    .filter((u) -> u.getId() == id)
                    .findFirst()
                    .get();
        }catch(NoSuchElementException e){
            throw new UserNotFoundException("There's no user with id "+id+".");
        }
    }
}
