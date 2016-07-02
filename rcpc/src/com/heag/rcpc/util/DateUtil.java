package com.heag.rcpc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2015-6-17 0017.
 */
public class DateUtil {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws ParseException {
        String date = "2011-02-25";
        System.out.println(date);
        System.out.println("年份：" + getYear(date));
        System.out.println("月份：" + getMonth(date));
        System.out.println("日期：" + getDay(date));
        System.out.println("月初日期是: " + getMinMonthDate(date));
        System.out.println("月末日期是: " + getMaxMonthDate(date));
    }

    /**
     * 获取日期年份
     * @param date
     * @return
     * @throws ParseException
     */
    public static int getYear(String date) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(date));  
        return calendar.get(Calendar.YEAR);
    }

    /**  
     * 获取日期月份     
     * @param date
     * @return
     * @throws ParseException
     */
    public static int getMonth(String date) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(date));
        return (calendar.get(Calendar.MONTH) + 1);
    }

    /**
     * 获取日期号
     * @param date
     * @return
     * @throws ParseException
     */
    public static int getDay(String date) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(date));
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
    /**
     * 获取月份起始日期
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getMinMonthDate(String date) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return dateFormat.format(calendar.getTime());
    }

    /**
     * 获取月份最后日期
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getMaxMonthDate(String date) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dateFormat.format(calendar.getTime());
    }

    /**
     * 返回月的月初日期和月末日期包括时分秒
     * @param year
     * @param month 月从1开始
     * @return Date[月初,月末]
     */
    public static Date[] getMonthStartAndEndDate(Integer year,Integer month){
        Calendar calendar = Calendar.getInstance();
        //月初
        calendar.set(year, month-1, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date start = calendar.getTime();

        //月末
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        Date end = calendar.getTime();

        return new Date[]{start,end};
    }

    /**
     * 返回上月
     *
     * @param date 日期
     * @return 数组[年,月]
     */
    public static int[] getPrevMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1); //上月

        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH) + 1;

        return new int[]{y,m};
    }

    /**
     * 返回一天的起始和结束时间
     * @param day 2011-01-02
     * @return
     */
    public static Date[] getDayStartAndEnd(String day){
        Date[] startAndEnd = null;
        try{
            startAndEnd = getDayStartAndEnd(dateFormat.parse(day));
        }catch(Exception e){
            e.printStackTrace();
        }
        return startAndEnd;
    }

    /**
     * 返回一天的起始和结束时间
     * @param date
     * @return
     */
    public static Date[] getDayStartAndEnd(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        //开始
        calendar.set(year, month, day,0,0,0);
        Date start = calendar.getTime();

        //结束
        calendar.set(year, month, day,23,59,59);
        Date end = calendar.getTime();

        return new Date[]{start,end};
    }

}
