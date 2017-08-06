package com.yoyo.gamecenter.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
public class DateUtil {

    // 把两个时间差，三天内的时间用今天，昨天，前天表示，后跟时间，无日期
    public static String convertDateTime(Date date){
        if (date == null){
            return "";
        }
        String result = "";
        Date currentDateTime = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(currentDateTime);
        if(currentCalendar.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && currentCalendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)){

            if(dateDiff("hour",date,currentDateTime)<10){//如果date和当前时间间隔在10小时内
                if (dateDiff("hour", date, currentDateTime) > 0)
                    return dateDiff("hour", date, currentDateTime) + "小时前";

                if (dateDiff("minute", date, currentDateTime) > 0)
                    return dateDiff("minute", date, currentDateTime) + "分钟前";

                if (dateDiff("second", date, currentDateTime) >= 0)
                    return dateDiff("second", date, currentDateTime) + "秒前";
                else
                    return "刚才";//为了解决postdatetime时间精度不够导致时间问题的兼容
            }else{
                int dif = currentCalendar.get(Calendar.DAY_OF_MONTH) - calendar.get(Calendar.DAY_OF_MONTH);
                switch (dif){
                    case 0:
                        result = "今天"+ new SimpleDateFormat("HH:mm").format(date);
                        break;
                    case 1:
                        result = "昨天"+ new SimpleDateFormat("HH:mm").format(date);
                        break;
                    case 2:
                        result = "前天"+ new SimpleDateFormat("HH:mm").format(date);
                        break;
                    default:
                        result = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
                        break;
                }
            }

        }else{
            result = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
        }
        return result;
    }

    //两个时间的差值，可以为秒，小时，天，分钟
    public static long dateDiff(String interval, Date startDate, Date endDate){
        long lngDateDiffValue = 0;
        long between = endDate.getTime() - startDate.getTime();
        if(interval.equals("second")){
            lngDateDiffValue = between/1000;
        }else if(interval.equals("minute")){
            lngDateDiffValue = between/1000/60;
        }else if(interval.equals("hour")){
            lngDateDiffValue = between/1000/60/60;
        }
        return lngDateDiffValue;
    }
}
