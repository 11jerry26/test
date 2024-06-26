package com.example.test.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Homework {
    private String id;
    private String title;
    private String description;
    @JsonProperty("isRelease")
    private boolean isRelease;
    private String releaseTime;
    private String ddl;
    private String file;
    private double totalScore;
    private boolean allowLate;

    public Homework() {
    }

    public Homework(String id, String title, String description, boolean isRelease, String releaseTime, String ddl, String file, double totalScore, boolean allowLate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isRelease = isRelease;
        this.releaseTime = releaseTime;
        this.ddl = ddl;
        this.file = file;
        this.totalScore = totalScore;
        this.allowLate = allowLate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRelease() {
        return isRelease;
    }

    public void setRelease(boolean Release) {
        isRelease = Release;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getDdl() {
        return ddl;
    }

    public void setDdl(String ddl) {
        this.ddl = ddl;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public boolean isAllowLate() {
        return allowLate;
    }

    public void setAllowLate(boolean allowLate) {
        this.allowLate = allowLate;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isRelease=" + isRelease +
                ", releaseTime='" + releaseTime + '\'' +
                ", ddl='" + ddl + '\'' +
                ", file='" + file + '\'' +
                ", totalScore=" + totalScore +
                ", allowLate=" + allowLate +
                '}';
    }
}
