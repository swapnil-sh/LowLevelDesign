package com.example.splitwise.model.split;

import com.example.splitwise.model.User;

public class PercentSplit extends Split{
    double amount;
    PercentSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }
}
