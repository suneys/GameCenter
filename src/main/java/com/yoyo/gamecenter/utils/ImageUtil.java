package com.yoyo.gamecenter.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/6/21 0021.
 */
public class ImageUtil {

    /**
     * 生成缩略图
     * @param imgFile 原图文件
     * @param width 缩略图的宽度
     * @param heigth 缩略图的高度
     * @param thumbPath  缩略图的保存路径
     * @param suffix 缩略图的后缀名
     */
    public static void thumbnailImage(File imgFile,int width,int heigth,String thumbPath,String suffix){
        try {
            Image img = ImageIO.read(imgFile);
            BufferedImage bi = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.getGraphics();
            g.drawImage(img, 0, 0, width, heigth, Color.LIGHT_GRAY, null);
            g.dispose();
            ImageIO.write(bi,suffix,new File(thumbPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
