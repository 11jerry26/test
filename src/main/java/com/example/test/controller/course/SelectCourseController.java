package com.example.test.controller.course;


import com.example.test.service.CourseService;
import com.example.test.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@SuppressWarnings("all")
@RequestMapping("/course")
@CrossOrigin
public class SelectCourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;
    private static final String KEY = "huterox"; //加密秘钥

    @PostMapping("/select")
    public Map<String,Object> selectCourseInfo(@RequestParam("token") String token) {
        //得到登录用户的账号
        Claims claims = null;
        claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        String userLoginAccount = claims.getSubject();
        String userAccount = userService.selectUserAccountByLogin(userLoginAccount);
        return courseService.selectYourCourse(userAccount);
    }
}
