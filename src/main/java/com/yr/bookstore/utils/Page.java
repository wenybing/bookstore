package com.yr.bookstore.utils;

import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 */
public class Page<T> {
    /**
     * 开始索引
     */
    private int index;
    /**
     * 每页显示的条数
     */
    private int pageSize = 4;
    /**
     * 当前页
     */
    private int pageNumber;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 总记录数
     */
    private int totalRecord;
    /**
     * 分页数据
     */
    private List<T> data;

    public Page() {
    }

    /**
     * 分页索引
     * @return
     */
    public int getIndex() {
        /**
         * 分页数据查询：select * from book limit 0,5
         *
         * 页码(pageNumber)   开始索引(index)    每页显示的条数(pageSize)
         *      1                0                      5
         *      2                5                      5
         *      3                10                     5
         *      4                15                     5
         *
         *      index = (pageNumber-1)*pageSize
         */
        index =(getPageNumber()-1)*pageSize;
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    /**
     * 获取当前页码
     * @return
     */
    public int getPageNumber() {
        if(pageNumber < 1){
            pageNumber = 1;
        }
        if(pageNumber > getTotalPage()){
            pageNumber = getTotalPage();
        }
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotalPage() {
        /**
         * 总记录数(totalRecord)         每页显示的条数(pageSize)            总页数(totalPage)
         *          20                          5                               4
         *          19                          5                               4
         *          18                          5                               4
         *          17                          5                               4
         *          16                          5                               4
         *          15                          5                               3
         *          14                          5                               3
         *          能整出
         *          totalPage = totalRecord/pageSize;
         *          不能整出
         *          totalPage = totalRecord/pageSize+1;
         */
        if(totalRecord%pageSize == 0){
            totalPage = getTotalRecord()/pageSize;
        }else{
            totalPage = getTotalRecord()/pageSize+1;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
