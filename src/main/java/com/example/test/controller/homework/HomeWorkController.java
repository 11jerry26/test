package com.example.test.controller.homework;

import com.example.test.entity.Homework;
import com.example.test.service.HomeworkService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("all")
@RequestMapping("/homework")
@CrossOrigin
public class HomeWorkController {
    @Autowired
    private HomeworkService homeworkService;

    @PostMapping("/create")
    public String createCourse(@RequestParam("homework") String homeworkJson,
                               @RequestParam("code") String code,
                               @RequestParam("userToken") String token){
        int i = homeworkService.createHomework(token,code,homeworkJson);
        if (i > 0) {
            return "创建成功";
        } else{
            return "创建失败";
        }
    }

    @PostMapping("/selectHomework")
    public List<Homework> getHomeworkList(@RequestParam("code") String code) {
        return homeworkService.getHomeworkListByCode(code);
    }

    @PostMapping("/selectCounts")
    public List<Integer> getHomeworkCounts(@RequestParam("homeworkId") String id,@RequestParam("code") String code) {
        return homeworkService.getHomeworkCounts(id,code);
    }
}

