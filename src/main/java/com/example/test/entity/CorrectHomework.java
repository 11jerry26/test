package com.example.test.entity;

public class CorrectHomework {
    private String account;
    private String name;
    private String content;
    private String message;
    private String score;
    private String comment;

    public CorrectHomework() {
    }

    public CorrectHomework(String account, String name, String content, String message, String score, String comment) {
        this.account = account;
        this.name = name;
        this.content = content;
        this.message = message;
        this.score = score;
        this.comment = comment;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
