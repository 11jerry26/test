package com.example.test.service.impl;

import com.example.test.entity.Student;
import com.example.test.entity.User;
import com.example.test.mapper.UserMapper;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 何建宇
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int selectUser(String account, String password) {
        if (userMapper.selectUser(account) != null){
            User user = userMapper.selectUser(account);
            if (password.equals(user.getPassword())){
                return 1; //账号，密码正确
            }
            else {
                return 2; //账号正确，密码错误
            }
        }
        else {
            return 0; //账号不存在
        }
    }

    @Override
    public int addUser(User user) {
            return userMapper.insertUser(user);
    }

    @Override
    public User changeToUser(String account, String password, String name, String school){
        return new User(account,password,name,school);
    }

    @Override
    public User selectUserByAccount(String account){
        return userMapper.selectUser(account);
    }
}
