package com.littlebuddha.community.base.entity;

import com.littlebuddha.community.base.page.Page;
import com.littlebuddha.community.sys.entity.User;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity<E> implements Serializable {

    private String id;
    private Date createDate;
    private User createBy;
    private Date updateDate;
    private User updateBy;


    /**
     * 当前实体分页对象
     */
    protected Page<E> page;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getCreateBy() {
        return createBy;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public User getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(User updateBy) {
        this.updateBy = updateBy;
    }

    public Page<E> getPage() {
        if(page == null){
            page = new Page<E>();
        }
        return page;
    }

    public void setPage(Page<E> page) {
        this.page = page;
    }
}
