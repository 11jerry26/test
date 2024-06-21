package com.example.test.controller.course;


import com.example.test.service.CourseService;
import com.example.test.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@SuppressWarnings("all")
@RequestMapping("/course")
@CrossOrigin
public class JoinCourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;
    private static final String KEY = "huterox"; //加密秘钥
    @PostMapping("/join")
    public String createCourse(@RequestParam("token") String token,@RequestParam("code") String code){
        Claims claims = null;
        claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        String userLoginAccount = claims.getSubject();
        String userAccount = userService.selectUserAccountByLogin(userLoginAccount);
        int i = courseService.joinCourse(userAccount,code);
        if (i == -2) {
            return "输入的加课码不存在";
        } else if (i == -1) {
            return "已加入该课程";
        } else{
            return "加入成功";
        }
    }
}
