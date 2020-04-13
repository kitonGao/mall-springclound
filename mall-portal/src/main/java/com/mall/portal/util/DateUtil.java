package com.mall.portal.util;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * @program: mall-springclound
 * @description:
 * @author: gaojme
 * @create: 2020-04-10 16:13
 */
public class DateUtil {

    /**
     * 从Date类型的时间中提取日期部分
     * @param date
     * @return
     */
    public static Date getDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 从Date类型的时间中提取时间部分
     * @param date
     * @return
     */
    public static Date getTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, 1970);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }


    public static void main(String[] args) {
        System.out.println( getDate(new Date()));
        System.out.println(getTime(new Date()));
    }


}
