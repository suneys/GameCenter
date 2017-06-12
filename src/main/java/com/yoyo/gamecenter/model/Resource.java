package com.yoyo.gamecenter.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/26 0026.
 */
public class Resource {
    private long rId;
    private String fileName;            // 文件名称
    private int fileSize;               // 文件大小
    private String path;                // 原始图路径
    private String thumbPath;           // 缩略图路径
    private Date createTime;            // 创建时间
    private Short isDelete;             // 是否删除 0-未删除，1-删除
    private int souceType;              // 文件类型，0-图片，1-视频
    private long uId;                   // 外键，绑定用户id
    private List<Terminal> terminals;

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<Terminal> terminals) {
        this.terminals = terminals;
    }

    public long getrId() {
        return rId;
    }

    public void setrId(long rId) {
        this.rId = rId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getThumbPath() {
        return thumbPath;
    }

    public void setThumbPath(String thumbPath) {
        this.thumbPath = thumbPath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }

    public int getSouceType() {
        return souceType;
    }

    public void setSouceType(int souceType) {
        this.souceType = souceType;
    }

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }


    @Override
    public String toString() {
        return "Resource{" +
                "rId=" + rId +
                ", fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", path='" + path + '\'' +
                ", thumbPath='" + thumbPath + '\'' +
                ", createTime=" + createTime +
                ", isDelete=" + isDelete +
                ", souceType=" + souceType +
                ", uId=" + uId +
                ", terminals=" + terminals +
                '}';
    }

}
