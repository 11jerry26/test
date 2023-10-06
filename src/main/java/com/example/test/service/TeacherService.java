package com.example.test.service;

import com.example.test.entity.Teacher;

/**
 * @author 何建宇
 */
public interface TeacherService {
    public int selectTeacher(String account,String password);
    public int addTeacher(Teacher teacher);
    public int ifSame(Teacher teacher);
}
