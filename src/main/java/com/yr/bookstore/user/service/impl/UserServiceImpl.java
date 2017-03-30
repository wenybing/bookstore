package com.yr.bookstore.user.service.impl;

import com.yr.bookstore.user.bean.User;
import com.yr.bookstore.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/12/30.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
     private IUserService userService;
    /**
     * ×¢²á
     * @param user
     * @return
     */
    public void regist(User user) {
        userService.regist(user);
    }

    /**
     * µÇÂ¼
     * @param user
     * @return
     */
    public User login(User user) {
        return userService.login(user);
    }

    public User getUserByUserName(String username) {
        return userService.getUserByUserName(username);
    }
}
