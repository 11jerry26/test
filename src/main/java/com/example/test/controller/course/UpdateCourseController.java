package com.example.test.controller.course;

import com.example.test.entity.Course;
import com.example.test.service.CourseService;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@SuppressWarnings("all")
@RequestMapping("/course")
@CrossOrigin
public class UpdateCourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;
    @PostMapping("/update")
    public int selectCourseInfo(@RequestBody Course course, @RequestHeader ("Authorization") String name) {
        return courseService.updateTopping(course,name);
    }
}
