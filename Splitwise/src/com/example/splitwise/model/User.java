package com.example.splitwise.model;

public class User {
    int userId;
    String userName;
    String emailId;
    String phoneNo;

    public User() {
    }

    public User(int userId, String userName, String emailId, String phoneNo) {
        this.userId = userId;
        this.userName = userName;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
