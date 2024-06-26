package com.example.test.controller.correct;

import com.example.test.entity.CorrectHomework;
import com.example.test.entity.StudentHomework;
import com.example.test.service.CorrectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@SuppressWarnings("all")
@RequestMapping("/correct")
@CrossOrigin
public class CorrectController {
    @Autowired
    private CorrectService correctService;

    @PostMapping("/create")
    public String createStuHomework(@RequestParam("stuHomework") String stuHomeworkJson,
                               @RequestParam("userToken") String token){
        int i = correctService.createStuHomework(token,stuHomeworkJson);
        if (i > 0) {
            return "作答成功";
        } else{
            return "作答失败";
        }
    }

    @PostMapping("/update")
    public String updateStuHomework(@RequestParam("stuHomework") String stuHomeworkJson,
                               @RequestParam("userToken") String token){
        int i = correctService.updateStuHomework(token,stuHomeworkJson);
        if (i > 0) {
            return "更新作答成功";
        } else{
            return "更新作答失败";
        }
    }

    @PostMapping("/getStuHomework")
    public ResponseEntity<Map<String, Object>> getStuHomework(@RequestParam("id") String id, @RequestParam("userToken") String token) {
        StudentHomework studentHomework = correctService.getStuHomework(id,token);
        String score = correctService.getScore(id,token);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("stuHomework", studentHomework);
        responseMap.put("score", score);

        return ResponseEntity.ok(responseMap);
    }

    @PostMapping("/getStuHomeworkList")
    public List<CorrectHomework> getStuHomeworkList(@RequestParam("id") String id, @RequestParam("userToken") String token) {
        System.out.println("chachacha");
        return correctService.getStuHomeworkList(id, token);
    }

//    @PostMapping("/select")
//    public List<StudentHomework> getStuHomeworkList(@RequestParam("code") String code) {
//        return correctService.getStuHomeworkListByCode(code);
//    }
//
}

