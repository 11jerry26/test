package com.example.test.controller.course;

import com.example.test.entity.Course;
import com.example.test.service.CourseService;
import com.example.test.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public int selectCourseInfo(@RequestParam("course") String courseJson,@RequestParam("name") String name) {
        ObjectMapper objectMapper = new ObjectMapper();
        Course course = null;
        int i = 0;
        try {
            course = objectMapper.readValue(courseJson, Course.class);
            i = courseService.updateTopping(course,name);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
}
