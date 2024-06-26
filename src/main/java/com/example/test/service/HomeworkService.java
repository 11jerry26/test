package com.example.test.service;

import com.example.test.entity.Homework;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeworkService {
    public int createHomework(String token,String code, String homeworkJson);
    public List<String> getHomeworkIdsByCode(String code);
    public List<Homework> getHomeworkListByCode(String code);
    public List<Integer> getHomeworkCounts(String id,String code);
    public String deleteHomeworkById(String id);
}
