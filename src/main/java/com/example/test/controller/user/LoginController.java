package com.example.test.controller.user;

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
public class LoginController {
    @Autowired
    private UserService userService;

    //接收登录请求
    @PostMapping("/login")
    public TokenPassJson select(@RequestParam("account") String account, @RequestParam("password") String password){
        int i = userService.selectUser(account,password);
        TokenPassJson tokenPassJson = new TokenPassJson();
        if (i == 1){
            String token = TokenProccessor.createToken(account);
            tokenPassJson.setSuccess(1);
            tokenPassJson.setToken(token);
            return tokenPassJson;
        }
        else if (i == 2){
            tokenPassJson.setSuccess(2);
            tokenPassJson.setToken(null);
            return tokenPassJson;
        }
        tokenPassJson.setSuccess(0);
        tokenPassJson.setToken(null);
        return tokenPassJson;
    }
}
