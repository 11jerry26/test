package com.example.test.controller.user;


import com.example.test.entity.User;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class RegisterController {
    @Autowired
    private UserService userService;

    //接收register请求
    @PostMapping("/register")
    public String addUser(@RequestBody User user) {
        int i = userService.addUser(user);
        if (i > 0) {
            return "添加成功";
        } else {
            if (i == -1) {
                return "该学号已经存在";
            } else if (i == -2) {
                return "该邮箱/手机号已经被注册";
            } else {
                return "添加失败";
            }
        }
    }
}

