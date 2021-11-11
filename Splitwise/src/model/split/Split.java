package model.split;

import model.User;

public abstract class Split {

    private User user;
    double amount;

    public Split(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
