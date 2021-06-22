package com.liuxinchi.utils;

public class pageUtils {
    //当前页
    private int currentPage;
    //总共页数
    private int totalPage;
    //当前页第一条数据的索引
    private int currentCount;
    //总共数据数量
    private int totalCount;
    //一页有多少条数据
    public static final int PAGE_SIZE = 5;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        this.currentCount = (currentPage-1)*5;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.totalPage = (totalCount/5)+1;
    }
}
