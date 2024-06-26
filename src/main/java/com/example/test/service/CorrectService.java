package com.example.test.service;

import com.example.test.entity.CorrectHomework;
import com.example.test.entity.Homework;
import com.example.test.entity.StudentHomework;

import java.util.List;

public interface CorrectService {
    public int createStuHomework(String token, String stuHomeworkJson);
    public int updateStuHomework(String token, String stuHomeworkJson);
//    public List<Homework> getHomeworkListByCode(String code);
    public StudentHomework getStuHomework(String id, String token);
    public String getScore(String id, String token);
    public List<CorrectHomework> getStuHomeworkList(String id, String token);
}
