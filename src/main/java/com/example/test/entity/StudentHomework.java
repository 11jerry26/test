package com.example.test.entity;

public class StudentHomework {
    private String account;
    private String id;
    private String content;
    private String message;

    public StudentHomework() {
    }

    public StudentHomework(String account, String id, String content, String message) {
        this.account = account;
        this.id = id;
        this.content = content;
        this.message = message;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "StudentHomework{" +
                "account='" + account + '\'' +
                ", id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
