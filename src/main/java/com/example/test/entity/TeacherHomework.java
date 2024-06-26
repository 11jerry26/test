package com.example.test.entity;

public class TeacherHomework {
    private String account;
    private String id;
    private String stuAccount;
    private double score;
    private String comment;

    public TeacherHomework() {
    }

    public TeacherHomework(String account, String id, String stuAccount, double score, String comment) {
        this.account = account;
        this.id = id;
        this.stuAccount = stuAccount;
        this.score = score;
        this.comment = comment;
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

    public String getStuAccount() {
        return stuAccount;
    }

    public void setStuAccount(String stuAccount) {
        this.stuAccount = stuAccount;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "TeacherHomework{" +
                "account='" + account + '\'' +
                ", id='" + id + '\'' +
                ", stuAccount='" + stuAccount + '\'' +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                '}';
    }
}
