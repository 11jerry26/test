package com.example.test.controller;


import com.example.test.entity.User;
import com.example.test.service.UserService;
import com.example.test.utils.tokenPassJson.TokenPassJson;
import com.example.test.utils.tokenProccessor.TokenProccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 何建宇
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //接收学生注册请求
//    @PostMapping("/student")
//    public String addUser(@RequestParam("account") String account,@RequestParam("password") String password,
//                          @RequestParam("name") String name,@RequestParam("school") String school){
//        int i = userService.addUser(userService.changeToUser(account,password,name,school));
//        if (i > 0){
//            return "学生同步成功";
//        }else{
//            return "学生同步失败";
//        }
//    }

    //接收老师注册请求
    @PostMapping("/teacher")
    public String addUser(@RequestBody User user){
        int i = userService.addUser(user);
        if (i > 0){
            return "老师同步成功";
        }else{
            return "老师同步失败";
        }
    }

    //接收登录请求
//    @PostMapping("/login")
//    public TokenPassJson select(@RequestParam("account") String account, @RequestParam("password") String password){
//        int i = userService.selectUser(account,password);
//        TokenPassJson tokenPassJson = new TokenPassJson();
//        if (i == 1){
//            String token = TokenProccessor.createToken(account);
//            tokenPassJson.setSuccess(1);
//            tokenPassJson.setToken(token);
//            return tokenPassJson;
//        }
//        else if (i == 2){
//            tokenPassJson.setSuccess(2);
//            tokenPassJson.setToken(null);
//            return tokenPassJson;
//        }
//        tokenPassJson.setSuccess(0);
//        tokenPassJson.setToken(null);
//        return tokenPassJson;
    }
//}
