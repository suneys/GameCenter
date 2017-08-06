package com.yoyo.gamecenter.utils;

import java.io.File;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
public class VideoUtil {

    /**
     * 获取视频的时长
     * @param videPath 视频的路径
     * @return
     */
    public static long getVideoDuration(String videPath){
        File source = new File(videPath);
        Encoder encoder = new Encoder();
        try {
            MultimediaInfo info = encoder.getInfo(source);
            return info.getDuration();
        } catch (EncoderException e) {
            e.printStackTrace();
        }
        return 2000;
    }
}
