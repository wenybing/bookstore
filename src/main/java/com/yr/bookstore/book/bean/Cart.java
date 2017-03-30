package com.yr.bookstore.book.bean;

/**
 * Created by Administrator on 2017/2/6.
 */

import java.math.BigDecimal;
import java.util.*;

/**
 * 购物项
 */
public class Cart {
    /**
     * 用来存储购物项
     */
    private Map<String,CartItem> map = new LinkedHashMap<String, CartItem>();
    /**
     * 购买商品的总数
     */
    private int totalAmount;
    /**
     * 购买商品的总计金额
     */
    private double totalCount;

    /**
     * 获取所有购物项
     */
    public List<CartItem> getAllCartItem(){
        /**
         * 获取所有的购物项
         */
        Collection<CartItem> collection =  map.values();
        List<CartItem> list = new ArrayList<CartItem>(collection);
        return list;
    }

    /**
     * 添加购物项
     */
    public void AddCatItem2Cart(Book book){
        /**
         * 1.购物车中有商品
         * 2.购物车中没有商品
         */
        CartItem cartItem = map.get(book.getId() + "");
        if(cartItem == null){
            CartItem cartItem1= new CartItem();
            /**
             * 设置图书信息
             */
            cartItem1.setBook(book);
            /**
             * 设置购物项数量
             */
            cartItem1.setAmount(1);
            /**
             * 设置购物项金额
             */
            cartItem1.setCount(cartItem1.getAmount());
            map.put(book.getId()+"",cartItem1);
        }else{
            /**
             * 获取图书数量
             */
            int amount = cartItem.getAmount();
            cartItem.setAmount(amount+1);
        }
    }

    /**
     * 删除购物项
     */
    public void delCartItem(String bookId){
        map.remove(bookId);
    }

    /**
     * 清空购物车
     */
    public void clearCart(){
        map.clear();
    }

    public Cart() {
    }



    public int getTotalAmount() {
        /**
         * 获取所有的购物项
         */
        int totalAmount = 0;
        List<CartItem> list = getAllCartItem();
        for (CartItem cartItem : list) {
            /**
             * 获取单个购物项的数量
             */
        int amount = cartItem.getAmount();
            totalAmount +=amount;
        }
        return totalAmount;
    }


    public double getTotalCount() {
        /**
         * 获取所有的购物项
         *
         */
        BigDecimal totalCounts = new BigDecimal("0");
        List<CartItem> list = getAllCartItem();
        for (CartItem cartItem : list) {
            /**
             * 获取单个购物项的金额
             */
            double count = cartItem.getCount();
            BigDecimal counts = new BigDecimal(count+"");
            totalCounts = totalCounts.add(counts);
        }
        return totalCounts.doubleValue();
    }

}
