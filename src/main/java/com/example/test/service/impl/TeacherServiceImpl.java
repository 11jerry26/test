package com.example.test.service.impl;

import com.example.test.entity.Teacher;
import com.example.test.mapper.TeacherMapper;
import com.example.test.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 何建宇
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public int selectTeacher(String account, String password) {
        if (teacherMapper.selectTeacher(account) != null){
            Teacher teacher = teacherMapper.selectTeacher(account);
            if (password.equals(teacher.getPassword())){
                return 1; //账号，密码正确
            }
            else {
                return 2; //账号正确，密码错误
            }
        }
        else {
            return 0; //账号不存在
        }
    }

    @Override
    public int addTeacher(Teacher teacher) {
        if (ifSame(teacher) == 0){
            return teacherMapper.insertTeacher(teacher);
        }
        else {
            return -1;
        }
    }

    @Override
    public int ifSame(Teacher teacher) {  //判断数据库是否有该老师
        int ifSame = 0;
        List<Teacher> teachers = teacherMapper.findTeacher();
        for (Teacher teacher1 : teachers) {
            if (teacher.getAccount().equals(teacher1.getAccount())) {
                ifSame = 1;
                break;
            }
        }
        return ifSame;
    }
}
