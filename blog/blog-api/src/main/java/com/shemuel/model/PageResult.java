package com.shemuel.model;

import java.util.List;

/**
 * 分页结果集
 */
public class PageResult {
    private Integer pageNum;
    private Integer pageSize;
    private Long total;
    private List list;

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public List getList() {
        return list;
    }

    public PageResult(Long total, List list) {
        this.total = total;
        this.list = list;
    }
}
