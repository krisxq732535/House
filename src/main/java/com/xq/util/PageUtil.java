package com.xq.util;

//分页工具类
public class PageUtil {
    private Integer page=1;
    private Integer rows=3;

    public PageUtil() {
    }

    public PageUtil(Integer page, Integer rows) {
        this.page = page;
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "page=" + page +
                ", rows=" + rows +
                '}';
    }
}
