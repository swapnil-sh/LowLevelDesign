package com.example.splitwise.repository;

import com.example.splitwise.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
    }

    public User getUserFromDB(int userId) {

        for(User user : userList) {
            if(user.getUserId() == userId)
                return user;
        }
        return null;
    }

    public String addUserToDB(User user) {
        userList.add(user);
        return "User added to DB";
    }

    public String deleteUserFromDB(int userId) {
        userList.stream().forEach(user -> {
            if(userId == user.getUserId())
                userList.remove(user);
        });

        return "User deleted from DB";
    }
}
