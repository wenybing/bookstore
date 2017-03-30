package com.yr.bookstore.book.bean;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/2/6.
 * 购物项
 */
public class CartItem {
    /**
     * 购买的图书
     */
    private Book book;
    /**
     * 购买单本图书的金额
     */
    private double count;
    /**
     * 购买单本图书的数量
     */
    private int amount;

    public CartItem() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * 计算价额 单本图书的总计金额=单本图书的数量*单本图书的金额
     * 涉及计算钱的应使用BigDecimal amounts = BigDecimal(String val);
     * @return
     */
    public double getCount() {
//        count = amount*book.getPrice();
        BigDecimal amounts = new BigDecimal(amount+"");
        BigDecimal price = new BigDecimal(book.getPrice()+"");
        count = amounts.multiply(price).doubleValue();
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
