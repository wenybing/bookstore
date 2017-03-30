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
     * ���ͼ��
     * @param map
     */
    void saveBook(Map map);

    /**
     * ɾ��ͼ��
     * @param map
     */
    void delBook(Map map);

    /**
     * ����ͼ��
     * @param map
     */
    void updateBook(Map map);

    /**
     * ��ѯͼ��
     * @param map
     * @return
     */
    Book queryBook(Map map);

    /**
     * ��ȡ����ͼ��
     * @return
     */
    List<Book> getAllBook();

    /**
     * ��ҳ���ݲ�ѯ
     */

    List<Book> findBook(Map map);

    /**
     * ��ȡͼ���ܼ�¼��
     * @return
     */
    int totalRecord();
}
