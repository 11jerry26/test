package com.example.test.mapper;

import com.example.test.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 何建宇
 */    
@Mapper
public interface UserMapper {
        @Select("select * from user")
        public List<User> findUser();

        @Select("SELECT * FROM user WHERE account = #{account}")
        public User selectUser(@Param("account") String account);

        @Insert("insert into user values (#{name},#{account},#{password},#{school})")
        public int insertUser(User user);
    }
