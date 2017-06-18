package com.yoyo.gamecenter.utils;

/**
 * Created by Administrator on 2017/6/18 0018.
 */

/**
 * 所有的转换工具类
 */
public class ConvertUtil {

    /**
     * 转换文件大小
     * @param size
     * @return
     */
    public static String convertFileSize(double size){
        String[] units = new String[]{"B","KB","MB","GB","TB","PB"};
        double mod = 1024.0;
        int i = 0;
        while (size >= mod){
            size /= mod;
            i++;
        }
        return Math.round(size) +units[i];
    }

    public static String[][] sourceTypeDict = new String[][]{
            {"图片","0"},
            {"视频","1"},
    };
    public static String getSourceTypeName(int id){
        for (int i = 0; i < sourceTypeDict.length; i++){
            if(Integer.parseInt(sourceTypeDict[i][1]) == id){
                return sourceTypeDict[i][0];
            }
        }
        return "";
    }
}
