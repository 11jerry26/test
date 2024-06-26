package com.example.test.service.impl;


import com.example.test.entity.Homework;
import com.example.test.mapper.HomeworkMapper;
import com.example.test.service.CourseService;
import com.example.test.service.HomeworkService;
import com.example.test.service.UserService;
import com.example.test.utils.CourseIdGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import net.sf.jsqlparser.statement.select.Offset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    HomeworkMapper homeworkMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;
    private static final String KEY = "huterox"; //加密秘钥
    CourseIdGenerator courseIdGenerator = new CourseIdGenerator(0,0);

    @Override
    public int createHomework(String token,String code, String homeworkJson) {
        Claims claims = null;
        Homework homework = null;
        claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        String userLoginAccount = claims.getSubject();
        String userAccount = userService.selectUserAccountByLogin(userLoginAccount);
        List<String> stuAccounts = courseService.selectStuAccountByCode(code);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            homework = objectMapper.readValue(homeworkJson, Homework.class);
            homework.setId(String.valueOf(courseIdGenerator.nextId()));
            int i;
            if (Objects.equals(homework.getReleaseTime(), "") || Objects.equals(homework.getDdl(), "")) {
                i = homeworkMapper.createHomework(homework.getId(),homework.getTitle(),null,
                        null,homework.getFile(),homework.isRelease(),homework.getDescription(),code);
            } else {
                i = homeworkMapper.createHomework(homework.getId(),homework.getTitle(),homework.getReleaseTime(),
                        homework.getDdl(),homework.getFile(),homework.isRelease(),homework.getDescription(),code);
            }
            for (int j = 0; j < stuAccounts.size(); j ++) {
                homeworkMapper.teacherCreateHomework(userAccount,homework.getId(),stuAccounts.get(j));
            }
            return i;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getHomeworkIdsByCode(String code) {
        return homeworkMapper.getHomeworkIdsByCode(code);
    }

    @Override
    public List<Homework> getHomeworkListByCode(String code) {
        return homeworkMapper.getHomeworkListByCode(code);
    }

    @Override
    public List<Integer> getHomeworkCounts(String id,String code) {
        List<Integer> counts = new ArrayList<>();
        int totalCounts = courseService.selectCountByCode(code); //总人数
        int submitNum = homeworkMapper.selectSubmitNum(id); //学生提交作业人数

        int markingNum = homeworkMapper.selectMarkingNum(id); //已批改人数
        counts.add(markingNum);

        int unMarkingNum = submitNum - markingNum; //未批改人数 = 已提交 - 已批改
        counts.add(unMarkingNum);

        int unSubmitNum = totalCounts - submitNum; //未提交 = 总人数 - 已提交
        counts.add(unSubmitNum);

        return counts;
    }

    @Override
    public String deleteHomeworkById(String id) {
        int i = homeworkMapper.deleteTeaHomeworkById(id);
        int k = homeworkMapper.deleteHomeworkById(id);
        int j = homeworkMapper.deleteStuHomeworkById(id);
        if (i > 0 && k > 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @Override
    public String updateHomework(Homework homework) {
        int i = homeworkMapper.updateHomework(homework.getId(),homework.getTitle(),homework.getReleaseTime(),
                homework.getDdl(),homework.getFile(),homework.isRelease(),homework.getDescription());
        if (i > 0) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }
}
