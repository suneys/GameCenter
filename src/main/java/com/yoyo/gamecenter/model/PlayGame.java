package com.yoyo.gamecenter.model;

/**
 * 发布游戏的实体类，用于生产JSon
 * Created by Administrator on 2017/7/23 0023.
 */
public class PlayGame {

    private String gameName;                  //游戏名称
    private String path;                    //游戏下载路径
    private String thumbPath;               //游戏缩略图路径
    private String packageName;             //游戏包名',

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

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
