package com.example.test.mapper;

import com.example.test.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 何建宇
 */
@Mapper
public interface StudentMapper {
    @Select("select * from student")
    public List<Student> findStudent();

    @Select("SELECT * FROM student WHERE account = #{account}")
    public Student selectStudent(@Param("account") String account);

    @Insert("insert into student values (#{name},#{account},#{password},#{school},#{id})")
    public int insertStudent(Student student);
}
