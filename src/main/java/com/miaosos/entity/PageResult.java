package com.miaosos.entity;

import java.util.Map;

public class PageResult {

    private Integer currentPage;
    private Integer totlePage;
    private Integer pageNum;
    private Integer totleNum;
    private Map<Object,Object> pageData;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotlePage() {
        return totlePage;
    }

    public void setTotlePage(Integer totlePage) {
        this.totlePage = totlePage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotleNum() {
        return totleNum;
    }

    public void setTotleNum(Integer totleNum) {
        this.totleNum = totleNum;
    }

    public Map<Object, Object> getPageData() {
        return pageData;
    }

    public void setPageData(Map<Object, Object> pageData) {
        this.pageData = pageData;
    }
}
