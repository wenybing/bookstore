package com.yr.bookstore.utils;

import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 */
public class Page<T> {
    /**
     * ��ʼ����
     */
    private int index;
    /**
     * ÿҳ��ʾ������
     */
    private int pageSize = 4;
    /**
     * ��ǰҳ
     */
    private int pageNumber;
    /**
     * ��ҳ��
     */
    private int totalPage;
    /**
     * �ܼ�¼��
     */
    private int totalRecord;
    /**
     * ��ҳ����
     */
    private List<T> data;

    public Page() {
    }

    /**
     * ��ҳ����
     * @return
     */
    public int getIndex() {
        /**
         * ��ҳ���ݲ�ѯ��select * from book limit 0,5
         *
         * ҳ��(pageNumber)   ��ʼ����(index)    ÿҳ��ʾ������(pageSize)
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
     * ��ȡ��ǰҳ��
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
         * �ܼ�¼��(totalRecord)         ÿҳ��ʾ������(pageSize)            ��ҳ��(totalPage)
         *          20                          5                               4
         *          19                          5                               4
         *          18                          5                               4
         *          17                          5                               4
         *          16                          5                               4
         *          15                          5                               3
         *          14                          5                               3
         *          ������
         *          totalPage = totalRecord/pageSize;
         *          ��������
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
