package com.example.test.service.impl;


import com.example.test.entity.CorrectHomework;
import com.example.test.entity.Homework;
import com.example.test.entity.StudentHomework;
import com.example.test.mapper.CorrectMapper;
import com.example.test.mapper.HomeworkMapper;
import com.example.test.service.CorrectService;
import com.example.test.service.CourseService;
import com.example.test.service.HomeworkService;
import com.example.test.service.UserService;
import com.example.test.utils.CourseIdGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CorrectServiceImpl implements CorrectService {
    @Autowired
    CorrectMapper correctMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;
    private static final String KEY = "huterox"; //加密秘钥
    CourseIdGenerator courseIdGenerator = new CourseIdGenerator(0,0);

    @Override
    public int createStuHomework(String token, String stuHomeworkJson) {
        Claims claims = null;
        StudentHomework studentHomework = null;
        claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        String userLoginAccount = claims.getSubject();
        String userAccount = userService.selectUserAccountByLogin(userLoginAccount);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            studentHomework = objectMapper.readValue(stuHomeworkJson, StudentHomework.class);
            studentHomework.setAccount(userAccount);
            int i = correctMapper.createStuHomework(studentHomework);
            return i;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateStuHomework(String token, String stuHomeworkJson) {
        Claims claims = null;
        StudentHomework studentHomework = null;
        claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        String userLoginAccount = claims.getSubject();
        String userAccount = userService.selectUserAccountByLogin(userLoginAccount);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            studentHomework = objectMapper.readValue(stuHomeworkJson, StudentHomework.class);
            studentHomework.setAccount(userAccount);
            int i = correctMapper.updateStuHomework(studentHomework);
            return i;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public StudentHomework getStuHomework(String id, String token) {
        Claims claims = null;
        claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        String userLoginAccount = claims.getSubject();
        String userAccount = userService.selectUserAccountByLogin(userLoginAccount);

        return correctMapper.getStuHomework(userAccount, id);
    }

    @Override
    public String getScore(String id, String token) {
        Claims claims = null;
        claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        String userLoginAccount = claims.getSubject();
        String userAccount = userService.selectUserAccountByLogin(userLoginAccount);

        return correctMapper.getScore(userAccount, id);
    }

    @Override
    public List<CorrectHomework> getStuHomeworkList(String id, String token) {
        Claims claims = null;
        claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        String userLoginAccount = claims.getSubject();
        String userAccount = userService.selectUserAccountByLogin(userLoginAccount);

        return correctMapper.getStuHomeworkList(id, userAccount);
    }

    @Override
    public int updateScore(String token, String id, String stuAccount, String score) {
        Claims claims = null;
        StudentHomework studentHomework = null;
        claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        String userLoginAccount = claims.getSubject();
        String userAccount = userService.selectUserAccountByLogin(userLoginAccount);

        return correctMapper.updateScore(userAccount, id, stuAccount, score);
    }
}
