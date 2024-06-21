package com.example.test.service.impl;

import com.example.test.entity.Course;
import com.example.test.mapper.CourseMapper;
import com.example.test.service.CourseService;
import com.example.test.utils.CourseIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author 何建宇
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

//    @Override
//    public int insertCourse(String year,String term,String courseName, String teachObject,String teacher,
//                            String addCourseCode, String teachWay,int numberOfStudents) {
//        Course course = new Course(year,term,courseName,teachObject,teacher,addCourseCode,teachWay,numberOfStudents);
//        return courseMapper.insertCourse(course);
//    }

    @Override
    public Course selectCourseByCode(String addCourseCode) {
        return courseMapper.selectCourse(addCourseCode);
    }

    //创建课程
    @Override
    public int createCourse(Course course,String userAccount) {
        CourseIdGenerator courseIdGenerator = new CourseIdGenerator(0,0);
        course.setCode(courseIdGenerator.nextCode(courseIdGenerator.nextId()));
        int i = courseMapper.createCourse(course);
        courseMapper.addTeacherAndCourse(userAccount,course.getCode());
        return i;
    }

    //根据加课码加入课程
    @Override
    public int joinCourse(String account,String code) {
        Course course = selectCourseByCode(code);
        if (course == null) {
            return -2; //输入的加课码不存在
        } else {
            int i = courseMapper.SelectExistJoinCourse(account,code);
            if (i > 0) {
                return -1; //已添加该课程
            } else {
                return courseMapper.joinCourse(account,code);
            }
        }
    }
}


