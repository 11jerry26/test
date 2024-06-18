package com.example.test.entity;

/**
 * @author 何建宇
 */
public class Course {
    private String year;
    private String term;
    private String name;
    private String teachObject;
    private String addCourseCode;
    private String responsiblePerson;
    private int numberOfStudents;
    private String teachWay;

    public Course(){}

    public Course(String year,String term, String name, String teachObject, String responsiblePerson,String addCourseCode, String teachWay,int numberOfStudents) {
        this.year = year;
        this.term = term;
        this.name = name;
        this.teachObject = teachObject;
        this.addCourseCode = addCourseCode;
        this.responsiblePerson = responsiblePerson;
        this.numberOfStudents = numberOfStudents;
        this.teachWay = teachWay;
    }

    public String getYear(){
        return year;
    }

    public void setYear(String year){
        this.year = year;
    }
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeachObject() {
        return teachObject;
    }

    public void setTeachObject(String teachObject) {
        this.teachObject = teachObject;
    }

    public String getAddCourseCode() {
        return addCourseCode;
    }

    public void setAddCourseCode(String addCourseCode) {
        this.addCourseCode = addCourseCode;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
    public String getTeachWay(){
        return teachWay;
    }
    public void setTeachWay(String teachWay){
        this.teachWay = teachWay;
    }

    @Override
    public String toString() {
        return "Course{" +
                "year='" + year + '\'' +
                ", term='" + term + '\'' +
                ", name='" + name + '\'' +
                ", teachObject='" + teachObject + '\'' +
                ", addCourseCode='" + addCourseCode + '\'' +
                ", responsiblePerson='" + responsiblePerson + '\'' +
                ", numberOfStudents='" + numberOfStudents + '\'' +
                ", teachWay='" + teachWay + '\'' +
                '}';
    }
}
