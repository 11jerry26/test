package com.example.test.service;

import com.example.test.entity.Student;
import com.example.test.entity.User;


/**
 * @author 何建宇
 */
public interface UserService {
    public int selectUser(String account,String password);
    public int addUser(User user);
    public User changeToUser(String account, String password, String name, String school);
    public User selectUserByAccount(String account);
}
