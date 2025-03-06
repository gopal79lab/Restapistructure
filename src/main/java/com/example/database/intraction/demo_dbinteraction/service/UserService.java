package com.example.database.intraction.demo_dbinteraction.service;

import com.example.database.intraction.demo_dbinteraction.model.User;
import com.example.database.intraction.demo_dbinteraction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository ;

    public User saveUser(User user){
        if (user.getName() == null) {
            throw new IllegalArgumentException("User name must not be null");
        }
        return  userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
         return userRepository.findById(id);
    }
public User updateUser(Long id , User updateduser){
        return userRepository.findById(id).map(
                user -> {
                    user.setName(updateduser.getName());
                    user.setEmail(updateduser.getEmail());
                    return userRepository.save(user);
                }
        ).orElseThrow(()-> new RuntimeException("User not found")) ;
} ;

    public void deleteuser(Long id){
        userRepository.deleteById(id);
    }



}
