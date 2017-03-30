package com.yr.bookstore.test;

import com.yr.bookstore.user.bean.User;
import com.yr.bookstore.user.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/1/1.
 */
public class BookStoreTest {

    private ApplicationContext  context = new ClassPathXmlApplicationContext("beans.xml");
    @Test
    public void getDataSource() throws SQLException {
        DataSource dataSource = (DataSource) context.getBean("dataSource");
       Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
//    @Test
//    public void regist(){
//        IUserService userService = context.getBean(IUserService.class);
//        User user = new User(0,"admin","admin","admin@126.com");
//        userService.regist(user);
//    }
}
