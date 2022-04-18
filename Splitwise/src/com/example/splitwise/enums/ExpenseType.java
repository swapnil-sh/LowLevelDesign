package com.example.splitwise.enums;

public enum ExpenseType {
    EQUAL("EQUAL"),
    EXACT ("EXACT"),
    PERCENT("PERCENT");

    public String expenseType;

    ExpenseType(String s) {
        expenseType = s;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public static boolean contains(String value) {
        for(ExpenseType expense: ExpenseType.values()) {
            if(value.equalsIgnoreCase(expense.getExpenseType()))
                return true;
        }
        return false;
    }
}
