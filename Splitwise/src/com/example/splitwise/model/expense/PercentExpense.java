package com.example.splitwise.model.expense;

import com.example.splitwise.model.User;
import com.example.splitwise.model.split.ExactSplit;
import com.example.splitwise.model.split.PercentSplit;
import com.example.splitwise.model.split.Split;

import java.util.List;

public class PercentExpense extends Expense {

    public PercentExpense(double expenseAmount, User expensePaidBy, List<Split> splits, String title) {
        super(expenseAmount, expensePaidBy, splits, title);
    }

    @Override
    public boolean validateExpense() {
        double totalSplitPercent = 0;
        for(Split split: getSplits()){
            if(!(split instanceof PercentSplit))
                return false;
            else {
                PercentSplit percentSplit = ((PercentSplit) split);
                totalSplitPercent += percentSplit.getPercent();
            }
        }
        return 100 == totalSplitPercent;
    }
}
