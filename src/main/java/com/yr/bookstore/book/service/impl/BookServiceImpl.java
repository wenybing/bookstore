package com.yr.bookstore.book.service.impl;

import com.yr.bookstore.book.bean.Book;
import com.yr.bookstore.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/4.
 */
@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookService bookService;
    /**
     * 保存图书
     * @param map
     */
    public void saveBook(Map map) {
        bookService.saveBook(map);
    }

    /**
     * 删除图书
     * @param map
     */
    public void delBook(Map map) {
        bookService.delBook(map);
    }

    /**
     * 更新图书
     * @param map
     */
    public void updateBook(Map map) {
        bookService.updateBook(map);
    }

    /**
     * 查询图书
     * @param map
     * @return
     */
    public Book queryBook(Map map) {
        return bookService.queryBook(map);
    }

    /**
     * 获取所有图书
     * @return
     */
    public List<Book> getAllBook() {
        return bookService.getAllBook();
    }

    public List<Book> findBook(Map map) {
        return bookService.findBook(map);
    }

    /**
     * 获取图书的总记录数
     * @return
     */
    public int totalRecord() {
        return bookService.totalRecord();
    }
}
