package com.yr.bookstore.test;

import com.yr.bookstore.book.bean.Book;
import com.yr.bookstore.book.bean.Cart;
import com.yr.bookstore.book.bean.CartItem;
import org.junit.Test;



/**
 * Created by Administrator on 2017/2/6.
 */
public class TestCart {
    @Test
    public void testAddCart(){
        /**
         *  Book(Integer id, String title, String author, double price, int sales, int stock, String imgPath)
         */
        Book book1 = new Book(1,"boo1","z1",10.0,10,200,null);
        Book book2 = new Book(2,"boo2","z1",50.0,10,200,null);
        Book book3 = new Book(3,"boo2","z1",80.0,10,200,null);
        CartItem cartItem = new CartItem();
        cartItem.setBook(book1);
        Cart cart = new Cart();
        cart.AddCatItem2Cart(book1);
        cart.AddCatItem2Cart(book2);
        cart.AddCatItem2Cart(book1);
        cart.AddCatItem2Cart(book2);
        cart.AddCatItem2Cart(book3);

        /**
         * É¾³ý¹ºÎïÏî
         */
        //cart.delCartItem(1+"");
        cart.clearCart();
        System.out.println(cart.getTotalAmount());
        System.out.println(cart.getTotalCount());
    }
}
