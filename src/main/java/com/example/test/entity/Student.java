package com.example.test.entity;

@SuppressWarnings("all")
public class Student {
    private String account;
    private String password;
    private String name;
    private String school;
    private String id;

    public Student(){}
    public Student(String account,String password,String name,String id,String school) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.id = id;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + account + '\'' +
                ", password='" + password + '\'' +
                ", school='" + school + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}



