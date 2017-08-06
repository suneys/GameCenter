package com.yoyo.gamecenter.model;

/**
 * Created by Administrator on 2017/6/30 0030.
 */
public class Game {
    private long gId;
    private String gameName;                  //游戏名称
    private String path;                    //游戏下载路径
    private String thumbPath;               //游戏缩略图路径
    private short g_isDelete;               //是否删除 0-未删除，1-删除
    private String packageName;             //游戏包名',
    private long uId;                       //外键，绑定用户id',
    private short gAttribute;

    public short getgAttribute() {
        return gAttribute;
    }

    public void setgAttribute(short gAttribute) {
        this.gAttribute = gAttribute;
    }

    public long getgId() {
        return gId;
    }

    public void setgId(long gId) {
        this.gId = gId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
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

    public short getG_isDelete() {
        return g_isDelete;
    }

    public void setG_isDelete(short g_isDelete) {
        this.g_isDelete = g_isDelete;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }
}
