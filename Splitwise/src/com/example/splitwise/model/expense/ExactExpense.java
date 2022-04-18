package com.example.splitwise.model.expense;

import com.example.splitwise.model.User;
import com.example.splitwise.model.split.ExactSplit;
import com.example.splitwise.model.split.Split;

import java.util.List;

public class ExactExpense extends Expense {
    public ExactExpense(double expenseAmount, User expensePaidBy, List<Split> splits, String title) {
        super(expenseAmount, expensePaidBy, splits, title);
    }

    @Override
    public boolean validateExpense() {
        double exactSplitAmount = 0;
        for(Split split: getSplits()){
            if(!(split instanceof ExactSplit))
                return false;
            else {
                exactSplitAmount+=split.getAmount();
            }
        }

        double totalExpenseAmount = getExpenseAmount();
        if(totalExpenseAmount != exactSplitAmount)
            return false;
        return true;
    }
}
