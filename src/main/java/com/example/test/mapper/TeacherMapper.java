package com.example.test.mapper;

import com.example.test.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 何建宇
 */
@Mapper
public interface TeacherMapper {
    @Select("select * from teacher")
    public List<Teacher> findTeacher();

    @Select("SELECT * FROM teacher WHERE account = #{account}")
    public Teacher selectTeacher(@Param("account") String account);

    @Insert("insert into teacher values (#{name},#{account},#{password},#{school})")
    public int insertTeacher(Teacher teacher);
}
