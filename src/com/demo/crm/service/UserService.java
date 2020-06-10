package com.demo.crm.service;

import com.demo.crm.pojo.User;
import org.springframework.stereotype.Service;

public interface UserService {
    public User checkUser(String usercode,String password);
}
