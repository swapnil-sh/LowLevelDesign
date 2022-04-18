package com.example.splitwise.repository;

import com.example.splitwise.model.expense.Expense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseRepository {
    List<Expense> expenseList;
    Map<String, Map<String, Double>> balanceSheet;

    public ExpenseRepository() {
        expenseList = new ArrayList<>();
        balanceSheet = new HashMap<>();
    }

    public Expense getExpense(String expenseId) {
        for(Expense expense : expenseList) {
            if((expense.getExpenseId()).equalsIgnoreCase(expenseId)) {
                return expense;
            }
        }
        return null;
    }

    public String addExpenseToDB(Expense expense) {
        expenseList.add(expense);
        return "Expense added to DB";
    }
}
