package com.example.test.service.impl;

import com.example.test.entity.Student;
import com.example.test.mapper.StudentMapper;
import com.example.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 何建宇
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired //自动注入依赖对象
    StudentMapper studentMapper;

    @Override
    public int selectStudent(String account,String password){
        if (studentMapper.selectStudent(account) != null){
            Student student = studentMapper.selectStudent(account);
            if (password.equals(student.getPassword())){
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
    public int addStudent(Student student){
        if (ifSame(student) == 0){
            return studentMapper.insertStudent(student);
        }
        else {
            return -1;
        }
    }

    @Override
    public int ifSame(Student student){   //判断数据库是否有该学生
        int ifSame = 0;
        List<Student> students = studentMapper.findStudent();
        for (Student stu : students) {
            if (student.getAccount().equals(stu.getAccount()) || student.getId().equals(stu.getId())) {
                ifSame = 1;
                break;
            }
        }
        return ifSame;
    }
}
