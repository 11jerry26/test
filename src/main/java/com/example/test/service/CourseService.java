package com.example.test.service;

import com.example.test.entity.Course;
import java.util.List;
import java.util.Map;


/**
 * @author 何建宇
 */
public interface CourseService {
    public Course selectCourseByCode(String addCourseCode);
    public int createCourse(Course course,String userAccount);
    public int joinCourse(String account,String code);
    public Map<String,Object> selectYourCourse(String account);
}
