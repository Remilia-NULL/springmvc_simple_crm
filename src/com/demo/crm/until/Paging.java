package com.demo.crm.until;


import java.util.ArrayList;
import java.util.List;

public class Paging<T> {
    private int currentpage;//当前页
    private int pagesize;//页面数据条数
    private int indexpage = 1;//首页
    private int count;//总数据条数
    private int pagenumber;//总页面数
    private List<T> rows;// 当前页的所有行。

    public Paging(List<T> datas, Integer currentpage, Integer pagesize) {
        if (datas == null || datas.size() == 0) {
            currentpage = 1;
            pagesize = 1;
            indexpage = 1;
            count = 0;
            pagenumber = 0;
            rows = null;
            return;
        }


        currentpage = currentpage < 1 ? 1 : currentpage;
        this.pagesize = pagesize;
        this.count = datas.size();
        pagenumber = count % pagesize == 0 ? count / pagesize : ( count / pagesize ) + 1;
        currentpage = currentpage > pagenumber ? pagenumber : currentpage ;
        this.currentpage = currentpage;

        int begin = (currentpage-1) * pagesize ;
        int end = currentpage * pagesize > count ? count : currentpage * pagesize ;

        rows = new ArrayList<T>();
        for( ; begin < end ; begin++) {
            rows.add(datas.get(begin));
        }
    }


    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getIndexpage() {
        return indexpage;
    }

    public void setIndexpage(int indexpage) {
        this.indexpage = indexpage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(int pagenumber) {
        this.pagenumber = pagenumber;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
