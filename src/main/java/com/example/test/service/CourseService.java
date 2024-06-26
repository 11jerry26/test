package com.example.test.service;

import com.example.test.entity.Course;
import org.apache.ibatis.annotations.Param;


/**
 * @author 何建宇
 */
public interface CourseService {

    public int insertCourse(String year,String term, String courseName, String teachObject, String responsiblePerson,
                            String addCourseCode, String teachWay, int numberOfStudents);
    public Course selectCourseByCode(String addCourseCode);
}
