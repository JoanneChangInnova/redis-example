package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @GetMapping("/users/clear/{id}")
    public void deleteUserById(@PathVariable Integer id){
        userService.clear(id);
    }

    @GetMapping("/users/clearAll")
    public void clearAllUserCache(){
        userService.clearAllUserCache();
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        // Logic to create a new user
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody User user){
        // Logic to update the user with the specified id
    }
}
