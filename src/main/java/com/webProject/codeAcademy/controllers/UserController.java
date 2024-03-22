package com.webProject.codeAcademy.controllers;

import com.webProject.codeAcademy.entities.User;
import com.webProject.codeAcademy.repositories.UserRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepositories userRepositories;

    public UserController(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepositories.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userRepositories.save(newUser);
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
        //custom exception ekle
        return userRepositories.findById(userId).orElse(null);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
        Optional<User> user = userRepositories.findById(userId);
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepositories.save(foundUser);
            return foundUser;
        } else {
            //custom exception ekle
            return null;
        }
    }

        @DeleteMapping("/{userId}")
        public void  deleteOneUser(@PathVariable Long userId){
           userRepositories.deleteById(userId);
        }
}
