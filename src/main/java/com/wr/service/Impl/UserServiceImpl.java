package com.wr.service.Impl;

import com.wr.entity.User;
import com.wr.mapper.UserMapper;
import com.wr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 王睿 on 2018/5/27.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User login(String username) {
        return userMapper.login(username);
    }
}
