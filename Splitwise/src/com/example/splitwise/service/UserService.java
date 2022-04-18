package com.example.splitwise.service;

import com.example.splitwise.model.User;
import com.example.splitwise.repository.UserRepository;

import java.util.List;

public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public String createNewUser(User user) {
        return userRepository.addUserToDB(user);

    }

    public User getUser(int userId) {
        return userRepository.getUserFromDB(userId);
    }

    public String deleteUser(int userId) {
        return userRepository.deleteUserFromDB(userId);
    }
}
