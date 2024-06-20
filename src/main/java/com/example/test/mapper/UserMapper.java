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

        //根据账号查询用户
        @Select("SELECT * FROM user WHERE account = #{account}")
        public User selectUserByAccount(@Param("account") String account);

        //根据账号查询用户
        @Select("SELECT * FROM user WHERE email = #{account}")
        public User selectUserByEmail(@Param("account") String account);

        //根据账号查询用户
        @Select("SELECT * FROM user WHERE phone = #{account}")
        public User selectUserByPhone(@Param("account") String account);

        @Insert("insert into user values (#{id},#{account},#{password},#{name},#{school},#{email},#{phone},#{role})")
        public int insertUser(User user);

        //查询所有学号
        @Select("select id from user where id is not null")
        public List<String> selectUserId();

        //查询所有非空邮箱
        @Select("select email from user where email is not null")
        public List<String> selectUserEmail();

        //查询所有非空电话
        @Select("select phone from user where phone is not null")
        public List<String> selectUserPhone();

        //根据登录邮箱查询账号{
        @Select("SELECT account FROM user WHERE email = #{email}")
        public String selectAccountByEmail(@Param("email") String email);

        //根据登录邮箱查询账号{
        @Select("SELECT account FROM user WHERE phone = #{phone}")
        public String selectAccountByPhone(@Param("phone") String phone);

//        @Insert("insert into user values (#{id},'1234567',#{password},#{name},#{school},null,#{account},#{role})")
//        public int insertUserWithPhone(User user);
    }
