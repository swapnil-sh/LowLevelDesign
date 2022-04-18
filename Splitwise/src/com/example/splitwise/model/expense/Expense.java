package com.example.splitwise.model.expense;

import com.example.splitwise.model.User;
import com.example.splitwise.model.split.Split;

import java.util.List;
import java.util.UUID;

public abstract class Expense {
    private final String expenseId;
    private double expenseAmount;
    private User expensePaidBy;
    private List<Split> splits;
    private String title;

    public Expense(double expenseAmount, User expensePaidBy, List<Split> splits, String title) {
        this.expenseId = UUID.randomUUID().toString();
        this.expenseAmount = expenseAmount;
        this.expensePaidBy = expensePaidBy;
        this.splits = splits;
        this.title = title;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public User getExpensePaidBy() {
        return expensePaidBy;
    }

    public void setExpensePaidBy(User expensePaidBy) {
        this.expensePaidBy = expensePaidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // To check the total splits add upto the total expense
    public abstract boolean validateExpense();
}
