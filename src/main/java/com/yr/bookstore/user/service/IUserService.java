package com.yr.bookstore.user.service;

import com.yr.bookstore.user.bean.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/12/30.
 */
@Repository
public interface IUserService {

    /**
     * ע���û�
     * @param user
     * @return
     */
    public void regist(User user);

    /**
     * ��¼�û�
     * @param user
     * @return
     */
    public User login(User user);

    public User getUserByUserName(String username);
}
