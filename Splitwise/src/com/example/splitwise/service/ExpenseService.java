package com.example.splitwise.service;

import com.example.splitwise.enums.ExpenseType;
import com.example.splitwise.model.User;
import com.example.splitwise.model.expense.EqualExpense;
import com.example.splitwise.model.expense.ExactExpense;
import com.example.splitwise.model.expense.Expense;
import com.example.splitwise.model.expense.PercentExpense;
import com.example.splitwise.model.split.Split;
import com.example.splitwise.repository.ExpenseRepository;

import java.util.List;

public class ExpenseService {

    ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public String createExpense(ExpenseType expenseType, double expenseAmount, User expensePaidBy, List<Split> splits, String title) {

        switch(expenseType.getExpenseType().toString()) {
            case "EQUAL":
                Expense equalExpense = new EqualExpense(expenseAmount, expensePaidBy, splits, title);
                expenseRepository.addExpenseToDB(equalExpense);
                break;

            case "EXACT":
                Expense exactExpense = new ExactExpense(expenseAmount, expensePaidBy, splits, title);
                expenseRepository.addExpenseToDB(exactExpense);
                break;

            case "PERCENT":
                Expense percentExpense = new PercentExpense(expenseAmount, expensePaidBy, splits, title);
                expenseRepository.addExpenseToDB(percentExpense);
                break;

            default:
                System.exit(0);
        }

        return "Expense added to DB";
    }
}
