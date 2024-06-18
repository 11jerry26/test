package com.example.test.controller;

import com.example.test.entity.User;
import com.example.test.service.CourseService;
import com.example.test.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 何建宇
 */
@RestController
@SuppressWarnings("all")
@RequestMapping("/")
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;
    private static final String KEY = "huterox"; //加密秘钥

    @PostMapping("/course")
    public String addCourse(@RequestParam("year") String year,@RequestParam("term") String term,
                            @RequestParam("courseName") String courseName, @RequestParam("teachObject") String teachObject,
                            @RequestParam("token") String token, @RequestParam("addCourseCode") String addCourseCode,
                            @RequestParam("teachWay") String teachWay, @RequestParam("numberOfStudents") int numberOfStudents){
        System.out.println(year + term + courseName + teachObject + token + addCourseCode + teachWay + numberOfStudents);
        Claims claims = null;
        claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        String userAccount = claims.getSubject();
        User user = userService.selectUserByAccount(userAccount);
        String responsiblePerson = user.getName();
        int i = courseService.insertCourse(year,term,courseName,teachObject,responsiblePerson,addCourseCode,teachWay,numberOfStudents);
        if (i > 0){
            return "创建成功";
        }
        else {
            return "创建失败";
        }
    }

}
