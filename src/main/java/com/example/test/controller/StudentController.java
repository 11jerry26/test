package com.example.test.controller;

import com.example.test.entity.Student;
import com.example.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@SuppressWarnings("all")
@RestController
@RequestMapping("/")
@CrossOrigin
public class StudentController {
    @Autowired
        private StudentService studentService;

//    接收login请求
        @PostMapping("/login")
        public String select(@RequestParam("account") String account,@RequestParam("password") String password){
            int i = studentService.selectStudent(account,password);
            if (i == 1){
                return "登录成功";
            }
            if (i == 2){
                return "密码错误";
            }
            else return "登录失败";
        }

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
