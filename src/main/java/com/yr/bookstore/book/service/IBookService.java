package com.yr.bookstore.book.service;

import com.yr.bookstore.book.bean.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/4.
 */

public interface IBookService {
    /**
     * 添加图书
     * @param map
     */
    void saveBook(Map map);

    /**
     * 删除图书
     * @param map
     */
    void delBook(Map map);

    /**
     * 更新图书
     * @param map
     */
    void updateBook(Map map);

    /**
     * 查询图书
     * @param map
     * @return
     */
    Book queryBook(Map map);

    /**
     * 获取所有图书
     * @return
     */
    List<Book> getAllBook();

    /**
     * 分页数据查询
     */

    List<Book> findBook(Map map);

    /**
     * 获取图书总记录数
     * @return
     */
    int totalRecord();
}
