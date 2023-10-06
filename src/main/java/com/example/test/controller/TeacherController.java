package com.example.test.controller;

import com.example.test.entity.Teacher;
import com.example.test.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 何建宇
 */
@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    //接收register请求
    @PostMapping("/register")
    public String addTeacher(@RequestBody Teacher teacher){
        int i = teacherService.addTeacher(teacher);
        if (i > 0){
            return "添加成功";
        }else{
            return "添加失败";
        }
    }
}
