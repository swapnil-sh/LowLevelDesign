package com.example.splitwise.repository;

import com.example.splitwise.model.expense.Expense;
import com.example.splitwise.model.split.Split;

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

        //https://stackoverflow.com/questions/2758224/what-does-the-java-assert-keyword-do-and-when-should-it-be-used
        assert expense != null;
        String userToBePaid = expense.getExpensePaidBy().getUserName();

        for(Split split : expense.getSplits()) {
            String userToPay = split.getUser().getUserName();

            Map<String, Double> balances = balanceSheet.get(userToBePaid);
            if(!balances.containsKey(userToPay))
                balances.put(userToPay, 0.0);

            balances.put(userToPay, balances.get(userToPay) + split.getAmount());

            balances = balanceSheet.get(userToPay);

            if(!balances.containsKey(userToBePaid))
                balances.put(userToBePaid, 0.0);

            balances.put(userToBePaid, balances.get(userToBePaid) + split.getAmount());
        }

        return "Balance Sheet Updated!";
    }

    public List<String> getBalance(String userName) {
        List<String> balances = new ArrayList<>();
        for (Map.Entry<String, Double> userBalance : balanceSheet.get(userName).entrySet()) {
            if (userBalance.getValue() != 0) {
                balances.add(checkSign(userName, userBalance.getKey(), userBalance.getValue()));
            }
        }
        return balances;
    }

    public List<String> getBalances() {
        List<String> balances = new ArrayList<>();
        for (Map.Entry<String, Map<String, Double>> allBalances : balanceSheet.entrySet()) {
            for (Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    balances.add(checkSign(allBalances.getKey(), userBalance.getKey(), userBalance.getValue()));
                }
            }
        }
        return balances;
    }

    private String checkSign(String user1, String user2, double amount) {

        if (amount < 0) {
            return  user1 + " owes " + user2 + ": " + Math.abs(amount);
        } else if (amount > 0) {
            return user2 + " owes " + user1 + ": " + Math.abs(amount);
        }

        return "";
    }
}
