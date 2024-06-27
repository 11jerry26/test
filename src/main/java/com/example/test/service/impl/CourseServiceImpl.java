package com.example.test.service.impl;

import com.example.test.entity.Course;
import com.example.test.mapper.CourseMapper;
import com.example.test.mapper.HomeworkMapper;
import com.example.test.mapper.UserMapper;
import com.example.test.service.CourseService;
import com.example.test.service.HomeworkService;
import com.example.test.utils.CourseIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @author 何建宇
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    HomeworkMapper homeworkMapper;
    @Autowired
    UserMapper userMapper;

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
        } else if (courseMapper.selectIsYours(account,code) > 0) {
            return 0;  //这是你创建的课程
        } else {
            int i = courseMapper.SelectExistJoinCourse(account,code);
            if (i > 0) {
                return -1; //已添加该课程
            } else {
                List<String> homeworkIds = homeworkMapper.getHomeworkIdsByCode(code);
                if (!homeworkIds.isEmpty()){
                    String teacherAccount = courseMapper.selectAccountByCode(code);
                    for (String homeworkId : homeworkIds) {
                        homeworkMapper.teacherCreateHomework(teacherAccount, homeworkId, account);
                    }
                }
                int change = courseMapper.addCourseCount(code);
                return courseMapper.joinCourse(account,code);
            }
        }
    }

    @Override
    public int addCourseCount(String code) {
        return courseMapper.addCourseCount(code);
    }

    //根据账号查询课程
    @Override
    public Map<String,Object> selectYourCourse(String account) {
        Map<String,Object> responseMap = new HashMap<>();
        List<Course> courses = new ArrayList<>();
        List<String> codes = courseMapper.selectCodeByAccount(account);
        List<String> names = new ArrayList<>();
        List<String> accounts = new ArrayList<>();
        List<Integer> isTops = new ArrayList<>();
        for (String code : codes) {
            Course course = courseMapper.selectCourseByCode(code);
            courses.add(course);
        }
        for (Course cours : courses) {
            String name = userMapper.selectUserNameByAccount(courseMapper.selectAccountByCode(cours.getCode()));
            names.add(name);
        }
        for (String name : names) {
            String acc = userMapper.selectUserAccountByName(name);
            accounts.add(acc);
        }
        for (int i = 0; i < codes.size(); i ++) {
            int isTop = courseMapper.selectIsTopByAccountAndCode(accounts.get(i),codes.get(i));
            isTops.add(isTop);
        }
        responseMap.put("names",names);
        responseMap.put("courses",courses);
        responseMap.put("isTops",isTops);
        return responseMap;
    }

    @Override
    public Map<String,Object> selectYourTopCourse(String account) {
        Map<String,Object> responseMap = new HashMap<>();
        List<Course> courses = new ArrayList<>();
        List<String> codes = courseMapper.selectTopCodeByAccount(account);
        List<String> names = new ArrayList<>();
        for (String code : codes) {
            Course course = courseMapper.selectCourseByCode(code);
            courses.add(course);
        }
        for (Course cours : courses) {
            String name = userMapper.selectUserNameByAccount(courseMapper.selectAccountByCode(cours.getCode()));
            names.add(name);
        }
        responseMap.put("names",names);
        responseMap.put("courses",courses);
        return responseMap;
    }

    //更改课程置顶状态
    @Override
    public int updateTopping(Course course, String name) {
        //得到用户的账号
        String account = userMapper.selectUserAccountByName(name);
        int role = userMapper.selectUserRoleByAccount(account);
        String code = course.getCode();
        int isTop;
        if (courseMapper.selectIsTopByAccountAndCode(account,code) == 0) {
            isTop = 1;
        } else {
            isTop = 0;
        }
        if (role == 1) {
            if (courseMapper.updateTeaTopping(account,code,isTop) != 0) {
                return courseMapper.updateTeaTopping(account,code,isTop);
            } else {
                return courseMapper.updateStuTopping(account,code,isTop);
            }
        } else {
            return courseMapper.updateStuTopping(account,code,isTop);
        }
    }

    //查询课程下的所有学生
    public List<String> selectStuAccountByCode(String code) {
        return courseMapper.selectStuAccountByCode(code);
    }

    public int selectCountByCode(String code) {
        return courseMapper.selectCountByCode(code);
    }

    @Override
    public int selectYourRole(String account,String code) {
        String teacherAccount = courseMapper.selectAccountByCode(code);
        if (Objects.equals(account, teacherAccount)) {
            return 1;
        } else {
            return 0;
        }
    }
}


