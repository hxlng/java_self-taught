package com.hqyj.hx.pojo;

import java.util.List;

/**
 * @author xfy
 * @create 2021-09-02 9:27
 */
/*
* 分页功能用到的数据模型
* */
public class PageData <T>{
    private int currentPage; //当前页码 起始值1
    private int pageSize; //每页显示的记录数
    private int totalPage; //共有多少页
    private int totalSize;//共有多少条记录
    private int previousPage; //上一页页码
    private int nextPage;//下一页页码
    private List<T> data; //当前页的记录集合

    public PageData() {
    }

    public PageData(int currentPage, int pageSize, int totalPage, int totalSize, int previousPage, int nextPage, List<T> data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalSize = totalSize;
        this.previousPage = previousPage;
        this.nextPage = nextPage;
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageData{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalSize=" + totalSize +
                ", previousPage=" + previousPage +
                ", nextPage=" + nextPage +
                ", data=" + data +
                '}';
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
