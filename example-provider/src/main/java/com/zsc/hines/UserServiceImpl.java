package com.zsc.hines;

import com.zsc.hines.model.User;
import com.zsc.hines.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
