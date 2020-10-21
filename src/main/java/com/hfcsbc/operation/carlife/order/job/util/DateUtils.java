package com.hfcsbc.operation.carlife.order.job.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author qidongliang
 * @email 18919656953@163.com
 * @dateTime 2020/10/19
 * @description xxx
 */
public class DateUtils {

    private static final String TIME_ZONE_OF_SHANGHAI = "Asia/Shanghai";

    public static final String DATE_PATTERN_DAY = "yyyy-MM-dd";

    public static String dateToStr(Date date, String pattern){
        return date == null ? "" : new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 获取某一天的最早时间
     */
    public static Date getOneDayStartTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取某一天的最晚时间
     */
    public static Date getOneDayEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取昨天的起始时间
     */
    public static Date getYesterdayStartTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        Date yesterdayDate = calendar.getTime();
        return getOneDayStartTime(yesterdayDate);
    }

    /**
     * 获取昨天的结束时间
     */
    public static Date getYesterdayEndTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        Date yesterdayDate = calendar.getTime();
        return getOneDayEndTime(yesterdayDate);
    }


}
