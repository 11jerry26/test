package com.example.test.entity;

/**
 * @author 何建宇
 */
public class Course {
    private String code;
    private String name;
    private String clazz;
    private String year;
    private String semester;
    private boolean isTop;
    private int count;
    private int type;
    private int codeStatus;

    public Course() {
    }

    public Course(String code, String name, String clazz, String year, String semester, boolean isTop, int count, int type, int codeStatus) {
        this.code = code;
        this.name = name;
        this.clazz = clazz;
        this.year = year;
        this.semester = semester;
        this.isTop = isTop;
        this.count = count;
        this.type = type;
        this.codeStatus = codeStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public boolean getIsTop() {
        return isTop;
    }

    public void setIsTop(boolean isTop) {
        this.isTop = isTop;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(int codeStatus) {
        this.codeStatus = codeStatus;
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", clazz='" + clazz + '\'' +
                ", year='" + year + '\'' +
                ", semester='" + semester + '\'' +
                ", isTop=" + isTop +
                ", count=" + count +
                ", type=" + type +
                ", codeStatus=" + codeStatus +
                '}';
    }
}
