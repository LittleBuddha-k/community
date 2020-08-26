package com.littlebuddha.community.base.page;

import java.util.ArrayList;
import java.util.List;

public class Page<E> {

    private Integer totalPage;//总的页码数
    private Integer pageNo;//传过来的页码

    private Integer offset;//经过转换的页码

    private boolean first;
    private boolean previous;
    private boolean next;
    private boolean last;
    private Integer size;//一页展示多少条数据

    List<E> list = new ArrayList<>();

    List<Integer> pages = new ArrayList<>();//装页码的list

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getOffset() {
        if(pageNo == 0 || pageNo == null || pageNo.equals("")){
            offset = 1;
        }else {
            offset = size*(pageNo - 1);
        }
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isPrevious() {
        return previous;
    }

    public void setPrevious(boolean previous) {
        this.previous = previous;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }

    public void setPageNation(int total, Integer pageNo, Integer size) {
        this.pageNo = pageNo;
        int totalPage = 0;
        if(total % size == 0){
            totalPage = total/size;
        }else {
            totalPage = total/size + 1;
        }

        /*设置页码*/
        if(pageNo < 1){
            pageNo = 1;
        }
        if(pageNo > totalPage){
            pageNo = totalPage;
        }
        pages.add(pageNo);
        for (int i =1;i<=3;i++){
            if(pageNo - i >0){
                pages.add(0,pageNo - i);
            }
            if(pageNo + i <= totalPage){
                pages.add(pageNo + i);
            }
        }

        /*上一页*/
        if(pageNo == 1){
            previous = false;
        }else {
            previous = true;
        }

        /*下一页*/
        if(pageNo == totalPage){
            next = false;
        }else {
            next = true;
        }

        /*第一页*/
        if(pages.contains(1)){
            first = false;
        }else {
            first = true;
        }

        /*最后一页*/
        if(pages.contains(totalPage)){
            last = false;
        }else {
            last = true;
        }
    }
}
