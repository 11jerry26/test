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

        @Insert("insert into user values (#{id},#{account},#{password},#{name},#{school},#{email},#{phone},#{role})")
        public int insertUser(User user);

        @Select("select id from user where id is not null")
        public List<String> selectUserId();

        @Select("select email from user where email is not null")
        public List<String> selectUserEmail();

        @Select("select phone from user where phone is not null")
        public List<String> selectUserPhone();

//        @Insert("insert into user values (#{id},'1234567',#{password},#{name},#{school},null,#{account},#{role})")
//        public int insertUserWithPhone(User user);
    }
