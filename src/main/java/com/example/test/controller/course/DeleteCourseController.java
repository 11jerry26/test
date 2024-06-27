package com.example.test.controller.course;

import com.example.test.entity.Course;
import com.example.test.service.CourseService;
import com.example.test.service.HomeworkService;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@SuppressWarnings("all")
@RequestMapping("/course")
@CrossOrigin
public class DeleteCourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private UserService userService;


    @PostMapping("/delete")
    public String deleteCourse(@RequestBody Course course){
        return courseService.deleteCourse(course);
    }

    @PostMapping("/deleteStu")
    public String deleteCourseStu(@RequestParam("course") String courseJson,@RequestParam("token") String token){
        return courseService.deleteCourseStu(courseJson,token);
    }
}
