package com.example.test.controller.course;


import com.example.test.entity.Course;
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
public class CreateCourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;
    private static final String KEY = "huterox"; //加密秘钥
    @PostMapping("/create")
    public String createCourse(@RequestBody Course course,@RequestHeader ("Authorization") String token){
        System.out.println("Token: " + token);
        Claims claims = null;
        claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        String userLoginAccount = claims.getSubject();
        String userAccount = userService.selectUserAccountByLogin(userLoginAccount);
        int i = courseService.createCourse(course,userAccount);
        if (i > 0) {
            return "创建成功";
        } else{
            return "创建失败";
        }
    }
}
