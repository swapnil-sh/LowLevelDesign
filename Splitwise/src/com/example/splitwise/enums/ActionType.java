package com.example.splitwise.enums;

public enum ActionType {
    EXPENSE("EXPENSE"),
    SHOW("SHOW"),
    QUIT("QUIT");

    public String actionType;

    ActionType(String expense) {
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionType() {
        return actionType;
    }

    public static boolean contains(String value) {
        for(ActionType action: ActionType.values()) {
            if(value.equalsIgnoreCase(action.getActionType()))
                return true;
        }

        return false;
    }
}
