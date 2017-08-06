package com.yoyo.gamecenter.model;

/**
 * 广告内容类
 * Created by Administrator on 2017/6/25 0025.
 */

public class Adviertisement {
    private String advPath;             //广告内容的路径
    private int souceType;              //广告类型，0-图片，1-视频
    private long showTime;               //广告播放时间，单位为毫秒秒

    public String getAdvPath() {
        return advPath;
    }

    public void setAdvPath(String advPath) {
        this.advPath = advPath;
    }

    public int getSouceType() {
        return souceType;
    }

    public void setSouceType(int souceType) {
        this.souceType = souceType;
    }

    public long getShowTime() {
        return showTime;
    }

    public void setShowTime(long showTime) {
        this.showTime = showTime;
    }
}
