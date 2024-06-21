package com.example.test.mapper;

import com.example.test.entity.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

////    创建课程
//    @Insert("insert into course values " +
//            "(#{year},#{term},#{name},#{teachObject},#{responsiblePerson},#{addCourseCode},#{teachWay},#{numberOfStudents})")
//    public int insertCourse(Course course);

    //创建课程
    @Insert("insert into course values (#{code},#{name},#{clazz},#{year},#{semester},#{isTop},#{count},#{type},#{codeStatus})")
    public int createCourse(Course course);

    @Insert("INSERT INTO teacher_course (account, code) VALUES (#{userAccount}, #{code})")
    public int addTeacherAndCourse(@Param("userAccount") String userAccount, @Param("code") String code);

    //加入课程
    @Insert("INSERT INTO student_course (account, code) VALUES (#{account}, #{code})")
    public int joinCourse(@Param("account") String account, @Param("code") String code);

    //查询是否重复加入课程
    @Select("SELECT COUNT(*) FROM student_course WHERE account = #{account} AND code = #{code}")
    public  int SelectExistJoinCourse(@Param("account") String account, @Param("code") String code);
}
