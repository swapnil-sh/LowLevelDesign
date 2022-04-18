package com.example.splitwise.model.split;

import com.example.splitwise.model.User;

public class PercentSplit extends Split{
    double percent;
    PercentSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
