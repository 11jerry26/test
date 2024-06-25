package com.example.test.controller.user;

import com.example.test.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@SuppressWarnings("all")
@RequestMapping("/user")
@CrossOrigin
public class SelectController {
    @Autowired
    private UserService userService;
    private static final String KEY = "huterox"; //加密秘钥

    //返回user的姓名
    @PostMapping("/select")
    public String selectUserName(@RequestParam("token") String token) {
        //得到登录用户的账号
        Claims claims = null;
        claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        String userLoginAccount = claims.getSubject();
        String userAccount = userService.selectUserAccountByLogin(userLoginAccount);

        return userService.selectUserNameByAccount(userAccount);
    }

    //返回user的role
    @PostMapping("/selectRole")
    public int selectUserRole(@RequestParam("token") String token) {
        //得到登录用户的账号
        Claims claims = null;
        claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        String userLoginAccount = claims.getSubject();
        String userAccount = userService.selectUserAccountByLogin(userLoginAccount);

        return userService.selectUserRoleByAccount(userAccount);
    }
}
