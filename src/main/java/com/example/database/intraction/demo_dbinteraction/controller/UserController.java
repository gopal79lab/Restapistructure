package com.example.database.intraction.demo_dbinteraction.controller;

import com.example.database.intraction.demo_dbinteraction.model.User;
import com.example.database.intraction.demo_dbinteraction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController //Success
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService ;

    @GetMapping //checked
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}") //checked
    public Optional<User> getUserById(@PathVariable  Long id){
       return   userService.getUserById(id);
    }

    @PostMapping //checked
    public ResponseEntity<User> saveUser(@RequestBody @Validated User user){

        User createdUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser) ;
    }
    @PutMapping("/{id}")
    public  void UpdateUser(@PathVariable Long id, @RequestBody User updatedUser){
        userService.updateUser(id,updatedUser);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteuser(id);
    }
}




