package com.example.test.service;

import com.example.test.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * @author 何建宇
 */
public interface CourseService {
    public Course selectCourseByCode(String addCourseCode);
    public int createCourse(Course course,String userAccount);
    public int joinCourse(String account,String code);
    public int addCourseCount(String code);
    public Map<String,Object> selectYourTopCourse(String account);
    public Map<String,Object> selectYourCourse(String account);
    public int updateTopping(Course course, String name);
    public List<String> selectStuAccountByCode(String code);
    public int selectCountByCode(String code);
    public int selectYourRole(String account,String code);
    public String deleteCourse(Course course);
    public String deleteCourseStu(String courseJson,String token);
}
