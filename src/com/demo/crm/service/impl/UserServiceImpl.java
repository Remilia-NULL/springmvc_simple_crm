package com.demo.crm.service.impl;

import com.demo.crm.mapper.UserMapper;
import com.demo.crm.pojo.User;
import com.demo.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User checkUser(String usercode, String password) {
        return userMapper.findUser(usercode, password);
    }
}
