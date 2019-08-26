package com.xiupeilian.carpart.model;

import java.util.Date;

public class Collections {
    private Integer id;

    private Integer colletorId;

    private Integer itemsId;

    private Date createTime;

    private Integer deleteStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getColletorId() {
        return colletorId;
    }

    public void setColletorId(Integer colletorId) {
        this.colletorId = colletorId;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}