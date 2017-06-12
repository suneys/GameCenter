package com.yoyo.gamecenter.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/12 0012.
 */
public class AdvFolder {
    private long fId ;
    private long pId;                   //父文件ID
    private String name;                //文件名
    private long uId;                   //用户ID
    private Date createDate;            //创建日期
    private Date updateDate;            //修改日期
    private Short isDelete;            //是否删除，0-未删除；1-已删除

    public long getfId() {
        return fId;
    }

    public void setfId(long fId) {
        this.fId = fId;
    }

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }
}
