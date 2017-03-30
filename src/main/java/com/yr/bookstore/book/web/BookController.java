package com.yr.bookstore.book.web;

import com.yr.bookstore.book.bean.Book;
import com.yr.bookstore.book.service.impl.BookServiceImpl;
import com.yr.bookstore.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/4.
 */
@Controller
@RequestMapping("/book/")
public class BookController {
    @Autowired
    private BookServiceImpl bookServiceImpl;

    /**
     * 保存图书
     * @param request
     * @return
     */
    @RequestMapping(value = "saveBook",method = RequestMethod.POST)
    public Object addBook(HttpServletRequest request,@RequestHeader("Referer") String referer){
        Map<String,Object> bookMap = new HashMap<String, Object>();
        bookMap.put("title",request.getParameter("title"));
        bookMap.put("author",request.getParameter("author"));
        bookMap.put("price",request.getParameter("price"));
        bookMap.put("sales",request.getParameter("sales"));
        bookMap.put("stock",request.getParameter("stock"));
        bookMap.put("imgPath",request.getParameter("imgPath"));
        bookServiceImpl.saveBook(bookMap);
        Page<Book> page = new Page<Book>();
        //获取总页数
        int totalRecord = bookServiceImpl.totalRecord();
        page.setTotalRecord(totalRecord);
        //获取总页数
        int totalPage = page.getTotalPage();
        return "redirect:findBook?pageNumber="+totalPage;
    }

    /**
     * 删除图书
     * @param id
     * @return
     */
    @RequestMapping(value="delBook",method = RequestMethod.DELETE)
    public Object delBook(@RequestParam("bookId") Integer id,@RequestHeader("Referer") String referer){
        Map<String,Object> bookMap = new HashMap<String, Object>();
        bookMap.put("id",id);
        bookServiceImpl.delBook(bookMap);
        System.out.println(referer+"*********************");
        return "redirect:"+referer;
//        return "redirect:findBook";
    }

    /**
     * 编辑图书
     * @param request
     * @return
     */
    @RequestMapping(value = "bookEdit",method = RequestMethod.PUT)
    public Object updateBook(HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id",request.getParameter("bookId"));
        map.put("title",request.getParameter("title"));
        map.put("author",request.getParameter("author"));
        map.put("price",request.getParameter("price"));
        map.put("sales",request.getParameter("sales"));
        map.put("stock",request.getParameter("stock"));
        map.put("imgPath", request.getParameter("imgPath"));
        bookServiceImpl.updateBook(map);
        return "redirect:findBook";
    }
    @RequestMapping(value = "queryBook",method = RequestMethod.GET)
    public Object queryBook(HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id", request.getParameter("bookId"));
        Book book = bookServiceImpl.queryBook(map);
        System.out.println(book);
        request.setAttribute("book",book);
        return "pages/manager/book_edit";
    }

    /**
     * 查询所有图书
     * @param request
     * @return
     */
    @RequestMapping(value = "bookList",method = RequestMethod.GET)
    public Object getAllBook(HttpServletRequest request){
        List<Book> bookList = bookServiceImpl.getAllBook();
        request.setAttribute("books",bookList);
        return "pages/manager/book_manager";
    }

    /**
     * 分页查询图书
     * @param request
     * @return
     */
    @RequestMapping(value = "findBook",method=RequestMethod.GET)
    public Object findBook(HttpServletRequest request){
        Page<Book> page = new Page<Book>();
        //获取图书的总记录数
        int totalRecord = bookServiceImpl.totalRecord();
        page.setTotalRecord(totalRecord);
        //获取当前页
        int pn = 1;
        String pageNumber = request.getParameter("pageNumber");
        if(pageNumber == "" || pageNumber == null){
            pn = 1;
        }else{
            try {
                pn = Integer.parseInt(pageNumber);
            }catch (Exception e){
            }
        }
        page.setPageNumber(pn);
        //获取开始索引
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("index",page.getIndex());
        map.put("pageSize",page.getPageSize());
        List<Book> data =  bookServiceImpl.findBook(map);
        page.setData(data);
        request.setAttribute("page",page);
        String type = request.getParameter("type");
        return "pages/manager/book_manager";
    }

    @RequestMapping(value = "findClientBook")
    public Object findClientBook(HttpServletRequest request){
        Page<Book> page = new Page<Book>();
        //获取图书的总记录数
        int totalRecord = bookServiceImpl.totalRecord();
        page.setTotalRecord(totalRecord);
        //获取当前页
        int pn = 1;
        String pageNumber = request.getParameter("pageNumber");
        if(pageNumber == "" || pageNumber == null){
            pn = 1;
        }else{
            try {
                pn = Integer.parseInt(pageNumber);
            }catch (Exception e){
            }
        }
        page.setPageNumber(pn);
        //获取开始索引
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("index",page.getIndex());
        map.put("pageSize",page.getPageSize());
        List<Book> data =  bookServiceImpl.findBook(map);
        page.setData(data);
        request.setAttribute("page",page);
        return "index";
    }
}
