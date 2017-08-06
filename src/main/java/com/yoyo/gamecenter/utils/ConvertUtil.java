package com.yoyo.gamecenter.utils;

/**
 * Created by Administrator on 2017/6/18 0018.
 */

import com.yoyo.gamecenter.contant.Content;
import com.yoyo.gamecenter.contant.DataType;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static String[][] PublishStateDict = new String[][]
    {
        {"尚未发布","0"},
        {"发布成功","1"},
        {"检查网络","2"},
    };

    public static String getPublishStateName(int Id)
    {
        for (int i = 0; i < PublishStateDict.length; i++)
        {
            if (Id == Integer.parseInt(PublishStateDict[i][1]))
            {
                return PublishStateDict[i][0];
            }
        }
        return "";
    }

    /**
     * 将扩展名转换成枚举类型
     * @param strExtension
     * @return
     */
    public static Content getFileExtension(String strExtension){
        if(("jpg,png,gif,bmp,jpge").contains(strExtension)){
            return Content.image;
        }else if(("mp4,avi").contains(strExtension)){
            return Content.video;
        }else{
            return Content.other;
        }
    }

    /**
     * 获取日期格式
     * @param type
     * @return
     */
    public static String getStrDate(DataType type){
        String date = "";
        switch (type){
            case N:
                date =new SimpleDateFormat("yyyy").format(new Date());
                break;
            case Y:
                date =new SimpleDateFormat("yyyyMM").format(new Date());
                break;
            case R:
                date =new SimpleDateFormat("yyyyMMdd").format(new Date());
                break;
            case S:
                date =new SimpleDateFormat("yyyyMMddHH").format(new Date());
                break;
            case F:
                date =new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
                break;
            case M:
                date =new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                break;
            case H:
                date =new SimpleDateFormat("yyyyMMddHHmmssfff").format(new Date());
                break;
        }
        return date;
    }
}
