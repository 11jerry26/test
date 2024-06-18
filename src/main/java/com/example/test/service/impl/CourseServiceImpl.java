package com.example.test.service.impl;

import com.example.test.entity.Course;
import com.example.test.mapper.CourseMapper;
import com.example.test.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 何建宇
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public int insertCourse(String year,String term,String courseName, String teachObject,String responsiblePerson,
                            String addCourseCode, String teachWay,int numberOfStudents) {
        Course course = new Course(year,term,courseName,teachObject,responsiblePerson,addCourseCode,teachWay,numberOfStudents);
        return courseMapper.insertCourse(course);
    }

    @Override
    public Course selectCourseByCode(String addCourseCode) {
        return courseMapper.selectCourse(addCourseCode);
    }

    }
