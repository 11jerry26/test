package com.example.test.entity;

/**
 * @author 何建宇
 */
public class User {
    private String account;
    private String password;
    private String name;
    private String school;

    public User(){}

    public User(String account, String password, String name, String school) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.school = school;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
