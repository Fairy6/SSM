package com.wr.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 王睿 on 2018/5/27.
 */
public class PageBean<T> implements Serializable {
    //当前页
    private int pageCode;

    //总页数=总条数/每页显示的条数
    private int totalPage;

    //总记录数
    private int totalCount;

    //每页显示的记录条数
    private int pagesize;

    //每页显示的数据
    private List<T> beanList;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}
