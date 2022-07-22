package com.homework.InsuranceApp.service;

import com.homework.InsuranceApp.configuration.SecurityConfiguration;
import com.homework.InsuranceApp.model.User;
import com.homework.InsuranceApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{
    private final UserRepository userRepository;
    @PostConstruct
    private void postConstruct(){
        User user1 = new User("Jon","Manebi","0756436657");
        User user2 = new User("Alegi","Marta","0747474565");
        User user3 = new User("Alfred","Julien","0734857713");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
    public List<User> findAll(){return userRepository.findAll();}
    public User getUserById(long id){return userRepository.get(id);}
    public User createUser(User user){
        return userRepository.save(user);
    }

    public User removeUserById(long id){
        return userRepository.remove(id);
    }

}
