package com.example.splitwise.model.split;

import com.example.splitwise.model.User;

public class ExactSplit extends Split {
    double amount;
    ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
