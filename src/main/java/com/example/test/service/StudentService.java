package com.example.test.service;

import com.example.test.entity.Student;


public interface StudentService {
    public int selectStudent(String account,String password);
    public int addStudent(Student student);
    public int ifSame(Student student);

}
