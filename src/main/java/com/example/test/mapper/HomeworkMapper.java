package com.example.test.mapper;

import com.example.test.entity.Course;
import com.example.test.entity.Homework;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    @Select("select count(*) from teacher_homework where id = #{id} and score != null")
    public int selectMarkingNum(@Param("id") String id);

    //根据课程码查询有多少人未批完

    public int selectUnMarkingNum(@Param("id") String id);
}
