package com.example.test.controller;

import com.example.test.entity.Student;
import com.example.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@SuppressWarnings("all")
@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
        private StudentService studentService;

//接收注册请求
        @PostMapping("/register")
        public String add(@RequestBody Student student){
            int i = studentService.addStudent(student);
            if (i > 0){
                return "添加成功";
            }else{
                return "添加失败";
            }
        }
    }
