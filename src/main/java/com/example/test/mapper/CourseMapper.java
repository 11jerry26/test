package com.example.test.mapper;

import com.example.test.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 何建宇
 */
@Mapper
public interface CourseMapper {
//    搜索所用课程
    @Select("select * from course")
    public List<Course> findCourse();

//    根据加课码查找课程
    @Select("SELECT * FROM course WHERE code = #{code}")
    public Course selectCourse(@Param("code") String code);

    //创建课程
    @Insert("insert into course values (#{code},#{name},#{clazz},#{year},#{semester},#{count},#{type},#{codeStatus})")
    public int createCourse(Course course);

    @Insert("INSERT INTO teacher_course (account, code) VALUES (#{userAccount}, #{code})")
    public int addTeacherAndCourse(@Param("userAccount") String userAccount, @Param("code") String code);

    //加入课程
    @Insert("INSERT INTO student_course (account, code) VALUES (#{account}, #{code})")
    public int joinCourse(@Param("account") String account, @Param("code") String code);

    //查询是否重复加入课程
    @Select("SELECT COUNT(*) FROM student_course WHERE account = #{account} AND code = #{code}")
    public  int SelectExistJoinCourse(@Param("account") String account, @Param("code") String code);

    //根据账号和课程码查询是否为自创课程
    @Select("SELECT COUNT(*) FROM teacher_course WHERE account = #{account} AND code = #{code}")
    public int selectIsYours(@Param("account") String account, @Param("code") String code);

    //根据用户账号查询课程码
    @Select("SELECT code FROM teacher_course WHERE account = #{account} UNION SELECT code FROM student_course WHERE account = #{account}")
    public List<String> selectCodeByAccount(@Param("account") String account);

    @Select("SELECT code FROM teacher_course WHERE account = #{account} AND isTop = 1 UNION SELECT code FROM student_course WHERE account = #{account} AND isTop = 1")
    public List<String> selectTopCodeByAccount(@Param("account") String account);

    //根据课程码查询用户账号
    @Select("SELECT account FROM teacher_course WHERE code = #{code}")
    public String selectAccountByCode(@Param("code") String code);

    //根据课程码查询课程
    @Select("SELECT * FROM course WHERE code = #{code}")
    public Course selectCourseByCode(@Param("code") String code);

    //根据账号和课程码更改当前置顶状态
    @Update("update teacher_course set isTop = #{isTop} where account = #{account} and code = #{code}")
    public int updateTeaTopping(@Param("account") String account,@Param("code") String code,@Param("isTop") int isTop);

    @Update("update student_course set isTop = #{isTop} where account = #{account} and code = #{code}")
    public int updateStuTopping(@Param("account") String account,@Param("code") String code,@Param("isTop") int isTop);

    //根据账号和课程码查询置顶状态
    @Select("SELECT isTop FROM teacher_course WHERE account = #{account} AND code = #{code} UNION SELECT isTop FROM student_course WHERE account = #{account} AND code = #{code}")
    public int selectIsTopByAccountAndCode(@Param("account") String account, @Param("code") String code);

}
