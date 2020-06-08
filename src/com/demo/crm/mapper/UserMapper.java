package com.demo.crm.mapper;

import com.demo.crm.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public User findUser(@Param("usercode") String usercode, @Param("password") String password);
}
