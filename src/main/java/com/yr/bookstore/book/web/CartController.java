package com.yr.bookstore.book.web;

import com.yr.bookstore.book.bean.Book;
import com.yr.bookstore.book.bean.Cart;
import com.yr.bookstore.book.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/6.
 */

/**
 * 购物车相关的controller
 */
@Controller
@RequestMapping("/cart/")
public class CartController {
    @Autowired
    private BookServiceImpl bookServiceImpl;
    /**
     * 添加购物车
     */
    @RequestMapping(value = "addCartItem",method = RequestMethod.GET)
    public Object addCart(HttpServletRequest request,@RequestHeader("Referer")String referer){
        /**
         *  获取session用于存储购物车信息
         */
        HttpSession session = request.getSession();
        /**
         * 获取bookId
         */
        String bookId = request.getParameter("bookId");
        /**
         * 根据bookId获取图书信息
         */
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id",bookId);
        Book book = bookServiceImpl.queryBook(map);
        /**
         *获取购物车信息
         */
        Cart cart = getCart(request);
        /**
         * 向购物车中添加购物项
         */
        cart.AddCatItem2Cart(book);

        return "redirect:"+referer;
    }

    /**
     * 清除购物项
     * @param request
     * @return
     */
    @RequestMapping(value = "delCartItem",method = RequestMethod.GET)
    public String delCartItem(HttpServletRequest request){
        Cart cart = getCart(request);
        String bookId = request.getParameter("bookId");
        cart.delCartItem(bookId);
        return "redirect:/jsp/pages/cart/cart.jsp";
    }

    /**
     * 清空购物车
     * @param request
     * @return
     */
    @RequestMapping(value="clearCart",method=RequestMethod.GET)
    public String clearCart(HttpServletRequest request){
        Cart cart = getCart(request);
        cart.clearCart();
        return "redirect:/jsp/pages/cart/cart.jsp";
    }

    public Cart getCart(HttpServletRequest request){
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        return cart;
    }

}
