package com.example.splitwise.model.expense;

import com.example.splitwise.model.User;
import com.example.splitwise.model.split.EqualSplit;
import com.example.splitwise.model.split.Split;

import java.util.List;

public class EqualExpense extends Expense {

    public EqualExpense(double expenseAmount, User expensePaidBy, List<Split> splits, String title) {
        super(expenseAmount, expensePaidBy, splits, title);
    }

    @Override
    public boolean validateExpense() {
        for(Split split: getSplits()){
            if(!(split instanceof EqualSplit))
                return false;
        }
        return true;
    }
}
