package com.example.test.mapper;

import com.example.test.entity.CorrectHomework;
import com.example.test.entity.StudentHomework;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface CorrectMapper {
    @Insert("INSERT INTO student_homework (account, id, content, message) " +
            "VALUES (#{stuHomework.account}, #{stuHomework.id}, #{stuHomework.content}, #{stuHomework.message})")
    public int createStuHomework(@Param("stuHomework") StudentHomework studentHomework);

    @Update("UPDATE student_homework SET content = #{stuHomework.content}, message = #{stuHomework.message} " +
            "WHERE account = #{stuHomework.account} AND id = #{stuHomework.id}")
    public int updateStuHomework(@Param("stuHomework") StudentHomework studentHomework);

    //根据学生账号和作业id查询作业内容
    @Select("select * from student_homework where account = #{userAccount} and id = #{id}")
    public StudentHomework getStuHomework(@Param("userAccount") String userAccount, @Param("id") String id);

    //根据学生账号和作业id查询成绩
    @Select("select score from teacher_homework where stuAccount = #{userAccount} and id = #{id}")
    public String getScore(@Param("userAccount") String userAccount, @Param("id") String id);

//    @Insert("insert into teacher_homework(account,id,stuAccount) values (#{account},#{id},#{stuAccount})")
//    public int teacherCreateHomework(@Param("account") String account,@Param("id") String id,@Param("stuAccount") String stuAccount);

//
    //根据教师账号和作业编号得到作业列表
    @Select("SELECT `user`.`name`, student_homework.content, student_homework.message, teacher_homework.score, teacher_homework.`comment` " +
            "FROM teacher_homework " +
            "JOIN student_homework ON student_homework.id = teacher_homework.id AND student_homework.account = teacher_homework.stuAccount " +
            "JOIN `user` ON `user`.account = teacher_homework.stuAccount " +
            "WHERE teacher_homework.id = #{id} AND teacher_homework.account = #{userAccount}")
    @Transactional
    public List<CorrectHomework> getStuHomeworkList(@Param("userAccount") String userAccount, @Param("id") String id);
//
//    @Select("select * from homework where code = #{code}")
//    public List<Homework> getHomeworkListByCode(@Param("code") String code);
//
//    //根据作业编号查询学生提交人数
//    @Select("select count(*) from student_homework where id = #{id}")
//    public int selectSubmitNum(@Param("id") String id);
//
//    //根据作业编号查询有多少人已批完
//    @Select("select count(*) from teacher_homework where id = #{id} and score != null")
//    public int selectMarkingNum(@Param("id") String id);
//
//    //根据课程码查询有多少人未批完
//
//    public int selectUnMarkingNum(@Param("id") String id);
}
