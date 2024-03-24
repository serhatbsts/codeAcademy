package com.webProject.codeAcademy.services;

import com.webProject.codeAcademy.entities.User;
import com.webProject.codeAcademy.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepositories userRepositories;

    public UserService(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    public List<User> getAllUsers() {
        return userRepositories.findAll();
    }

    public User saveOneUser(User newUser) {
        return userRepositories.save(newUser);
    }

    public User getOneUser(Long userId) {
        return userRepositories.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser) {
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

    public void deleteById(Long userId) {
        userRepositories.deleteById(userId);
    }
}
