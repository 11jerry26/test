package com.example.test.mapper;

import com.example.test.entity.Homework;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HomeworkMapper {
    @Insert("insert into teacher_homework(account,id,stuAccount) values (#{account},#{id},#{stuAccount})")
    public int teacherCreateHomework(@Param("account") String account,@Param("id") String id,@Param("stuAccount") String stuAccount);

    @Insert("insert into homework(id,title,releaseTime,ddl,file,isRelease,description,code) " +
            "values (#{id},#{title},#{releaseTime},#{ddl},#{file},#{isRelease},#{description},#{code})")
    public int createHomework(@Param("id") String id, @Param("title") String title, @Param("releaseTime") String releaseTime,
                              @Param("ddl") String ddl, @Param("file") String file,
                              @Param("isRelease") boolean isRelease,
                              @Param("description") String description, @Param("code") String code);

    //根据课程码查询作业id
    @Select("select id from homework where code = #{code}")
    public List<String> getHomeworkIdsByCode(@Param("code") String code);

    @Select("select * from homework where code = #{code}")
    public List<Homework> getHomeworkListByCode(@Param("code") String code);

    //根据作业编号查询学生提交人数
    @Select("select count(*) from student_homework where id = #{id}")
    public int selectSubmitNum(@Param("id") String id);

    //根据作业编号查询有多少人已批完
    @Select("select count(*) from teacher_homework where id = #{id} and score is not null")
    public int selectMarkingNum(@Param("id") String id);

    //根据作业编号删除作业
    @Delete("delete from teacher_homework where id = #{id}")
    public int deleteTeaHomeworkById(@Param("id") String id);

    @Delete("delete from student_homework where id = #{id}")
    public int deleteStuHomeworkById(@Param("id") String id);

    @Delete("delete from homework where id = #{id}")
    public int deleteHomeworkById(@Param("id") String id);

    @Update("update homework set title = #{title},releaseTime = #{releaseTime},ddl = #{ddl},file = #{file}," +
            "isRelease = #{isRelease},description = #{description} where id = #{id}")
    public int updateHomework(@Param("id") String id, @Param("title") String title, @Param("releaseTime") String releaseTime,
                              @Param("ddl") String ddl, @Param("file") String file,
                              @Param("isRelease") boolean isRelease,
                              @Param("description") String description);

    @Select("select count(*) from student_homework where id = #{id} and account = #{userAccount}")
    public int selectStuHomeworkById(@Param("id") String id, @Param("userAccount") String account);

    @Select("select score from teacher_homework where id = #{id} and stuAccount = #{userAccount}")
    public String selectStuHomeworkScore(@Param("id") String id,@Param("userAccount") String account);
}
