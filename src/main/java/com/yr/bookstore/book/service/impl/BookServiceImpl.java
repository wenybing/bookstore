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
     * ����ͼ��
     * @param map
     */
    public void saveBook(Map map) {
        bookService.saveBook(map);
    }

    /**
     * ɾ��ͼ��
     * @param map
     */
    public void delBook(Map map) {
        bookService.delBook(map);
    }

    /**
     * ����ͼ��
     * @param map
     */
    public void updateBook(Map map) {
        bookService.updateBook(map);
    }

    /**
     * ��ѯͼ��
     * @param map
     * @return
     */
    public Book queryBook(Map map) {
        return bookService.queryBook(map);
    }

    /**
     * ��ȡ����ͼ��
     * @return
     */
    public List<Book> getAllBook() {
        return bookService.getAllBook();
    }

    public List<Book> findBook(Map map) {
        return bookService.findBook(map);
    }

    /**
     * ��ȡͼ����ܼ�¼��
     * @return
     */
    public int totalRecord() {
        return bookService.totalRecord();
    }
}
