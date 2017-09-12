package com.xfn.dbLog.utils;


import com.xfn.dbLog.exception.XFNException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by po on 16/6/14.
 */
public class TimeUtil {


    public static String getTimeLink() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String rs = sdf.format(date);
        return rs;
    }

    public static String getDateLink() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String rs = sdf.format(date);
        return rs;
    }

    public static String getTimeUseMysql() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String rs = sdf.format(date);
        return rs;
    }

    public static String getDateUseMySql() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }


    public static String getYMRDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static SimpleDateFormat getYMDHms() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取YYYY/MM/DD日期格式
     *
     * @return
     */
    public static SimpleDateFormat getYearMonthDaySlashFormat() {
        return new SimpleDateFormat("yyyy/MM/dd");
    }

    /**
     * @param YearMonthDaySlashStr
     * @return
     */
    public static Date getYearMonthDayBySlashStringDate(String YearMonthDaySlashStr) throws ParseException {
        return getYearMonthDaySlashFormat().parse(YearMonthDaySlashStr);
    }


    /**
     * 两个YYYY／MM 格式月份之差
     * (YYYY-MM)
     *
     * @param startTime
     * @param yearMonth
     */
    public static int periodDiff(String startTime, String yearMonth) throws ParseException {
        int startYear = Integer.valueOf(startTime.substring(0, 4));
        int startMonth = Integer.valueOf(startTime.substring(5, 7));
        int endYear = Integer.valueOf(yearMonth.substring(0, 4));
        int endMonth = Integer.valueOf(yearMonth.substring(5, 7));
        return ((endYear - startYear) * 12) + (endMonth - startMonth);
    }

    /**
     * 2016-12-23 小白
     * 获取几个月后的年月
     *
     * @param year
     * @param month
     * @param num
     * @return
     */
    public static Calendar getNextNumMonthTime(int year, int month, int num) {
        Calendar calendar = Calendar.getInstance();
//        begin 2017-04-29 bike 修复当月份与天数不匹配时,设置的时间会增加一个月
//        calendar.set(year, month - 1, calendar.get(Calendar.DATE));
        calendar.set(year, month - 1, 1);
//        end 2017-04-29 bike 修复当月份与天数不匹配时,设置的时间会增加一个月
        calendar.add(Calendar.MONTH, num);
        return calendar;
    }

    /**
     * 2016-12-23 小白
     * 获取几个月后的年月
     *
     * @param year
     * @param month
     * @param num
     * @return
     */
    public static Calendar getNextNumMonthTime(String year, String month, int num) {
        Integer iYear = Integer.valueOf(year);
        Integer iMonth = Integer.valueOf(month);
        return getNextNumMonthTime(iYear, iMonth, num);
    }

    public static String getNextNumMonthTimeStr(String year, String month, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        Integer iYear = Integer.valueOf(year);
        Integer iMonth = Integer.valueOf(month);
        calendar.set(iYear, iMonth - 1, 1);
        calendar.add(Calendar.MONTH, num);
        return TimeUtil.format(calendar.getTime());
    }

    public static String getNextNumMonthTimeStr(int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, num);
        return TimeUtil.format(calendar.getTime());
    }

    public static String getNextNumMonthLastDayTimeStr(String year, String month, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        Integer iYear = Integer.valueOf(year);
        Integer iMonth = Integer.valueOf(month);
        calendar.set(Calendar.YEAR, iYear);
        calendar.set(Calendar.MONTH, iMonth - 1);
        calendar.add(Calendar.MONTH, num);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return TimeUtil.format(calendar.getTime());
    }

    /**
     * 2016-12-23 小白
     * 获取年
     *
     * @param calendar
     * @return
     */
    public static int getIntYearByCalendar(Calendar calendar) {
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 2016-12-23 小白
     * 获取月
     *
     * @param calendar
     * @return
     */
    public static int getIntMonthByCalendar(Calendar calendar) {
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 2016-12-23 小白
     * 获取字符串月，自动补齐'0'
     *
     * @param calendar
     * @return
     */
    public static String getStrMonthByCalendar(Calendar calendar) {
        int month = calendar.get(Calendar.MONTH) + 1;
        if (month > 9) {
            return String.valueOf(month);
        } else {
            return "0" + month;
        }
    }

    /**
     * 2016-12-23 小白
     * 获取字符串年
     *
     * @param calendar
     * @return
     */
    public static String getStrYearByCalendar(Calendar calendar) {
        return String.valueOf(calendar.get(Calendar.YEAR));
    }

    /**
     * 2017-04-05 xiaobai
     * 获取字符串年，自动获取后两位
     *
     * @param calendar
     * @return
     */
    public static String getStrYearForLastTwoByCalendar(Calendar calendar) {
        return String.valueOf(calendar.get(Calendar.YEAR)).substring(2);
    }

    /**
     * 2017-3-14 kongkong
     * 获取字符串天，自动补齐'0'
     *
     * @param calendar
     * @return
     */
    public static String getStrDataByCalendar(Calendar calendar) {
        int day = calendar.get(Calendar.DATE);
        if (day > 9) {
            return String.valueOf(day);
        } else {
            return "0" + day;
        }

    }

    /**
     * 2017-04-05 xiaobai
     * 获取字符小时分钟秒的timestamp字符串
     *
     * @param calendar
     * @return
     */
    public static String getTimeStampByCalendar(Calendar calendar) {
        int timeStamp = calendar.get(Calendar.HOUR) * 3600
                + calendar.get(Calendar.MINUTE) * 60
                + calendar.get(Calendar.SECOND);

        String str = String.valueOf(timeStamp);

        if (str.length() > 3) {
            str = str.substring(str.length() - 3, str.length());
        } else {
            while (str.length() < 3) {
                str = "0" + str;
            }
        }

        return str;
    }

    /**
     * 2017-3-15
     * 对时间格式化 安全考虑
     */

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static Date parse(String dateStr) throws ParseException {
        return threadLocal.get().parse(dateStr);
    }

    public static String format(Date date) {
        return threadLocal.get().format(date);
    }

    /**
     * 获取几个月后的日期
     *
     * @param time
     * @param payMonth
     * @return
     */
    public static String getTimeForValidTime(String time, int payMonth) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(time);
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, payMonth);
            return format.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            throw new XFNException(7);
        }
    }

    /**
     * 2017-05-08 xiaobai
     * 获取试用到期时间
     *
     * @param payMonth
     * @return
     */
    public static String getTimeForFreeTime(int payMonth) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, payMonth);
        return format.format(calendar.getTime()) + " 23:59:59";
    }

    /**
     * 2017-04-25 xiaobai
     * 获取两个时间的天数之差
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static int getDaysForTwoTime(String startTime, String endTime) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(startTime);
            Date date2 = sdf.parse(endTime);
            //将转换的两个时间对象转换成Calendard对象
            Calendar can1 = Calendar.getInstance();
            can1.setTime(date1);
            Calendar can2 = Calendar.getInstance();
            can2.setTime(date2);
            //拿出两个年份
            int year1 = can1.get(Calendar.YEAR);
            int year2 = can2.get(Calendar.YEAR);
            //天数
            int days = 0;
            Calendar can = null;
            //如果can1 < can2
            //减去小的时间在这一年已经过了的天数
            //加上大的时间已过的天数
            if (can1.before(can2)) {
                days -= can1.get(Calendar.DAY_OF_YEAR);
                days += can2.get(Calendar.DAY_OF_YEAR);
                can = can1;
            } else {
                days -= can2.get(Calendar.DAY_OF_YEAR);
                days += can1.get(Calendar.DAY_OF_YEAR);
                can = can2;
            }
            for (int i = 0; i < Math.abs(year2 - year1); i++) {
                //获取小的时间当前年的总天数
                days += can.getActualMaximum(Calendar.DAY_OF_YEAR);
                //再计算下一年。
                can.add(Calendar.YEAR, 1);
            }

            return days;
        } catch (ParseException e) {
            e.printStackTrace();
            throw new XFNException(7);
        }
    }

    /**
     * 2017-05-04 xiaobai
     * 判断订单时候已经过期
     *
     * @param orderTime
     * @return
     */
    public static String minLater(int minutes, String orderTime) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(orderTime);
            Calendar validCal = Calendar.getInstance();
            validCal.clear();
            validCal.setTime(date);
            validCal.add(Calendar.MINUTE, minutes);
            Calendar nowCal = Calendar.getInstance();
            if (nowCal.compareTo(validCal) > 0) {
                return sdf.format(validCal.getTime());
            } else {
                return "";
            }

        } catch (ParseException e) {
            e.printStackTrace();
            throw new XFNException(7);
        }
    }

    /**
     * 2017-07-08 bike
     * 用于获取下一个帐期
     *
     * @param year
     * @param month
     * @return
     */
    public static String getNextPeriod(String year, String month) {
        Calendar calendar = TimeUtil.getNextNumMonthTime(year, month, 1);
        year = String.valueOf(calendar.get(Calendar.YEAR));
        month = TimeUtil.getStrMonthByCalendar(calendar);
        return year + month;
    }

    /**
     * 2017-08-24 bike
     * 获取上一个帐期
     * @param year 年
     * @param month 余额
     */
    public static String getPreviousPeriod(String year, String month) {
        Calendar calendar = TimeUtil.getNextNumMonthTime(year, month, -1);
        year = String.valueOf(calendar.get(Calendar.YEAR));
        month = TimeUtil.getStrMonthByCalendar(calendar);
        return year + month;
    }

    /**
     * 20170801 kongkong
     *  获得一个月的最后一天的日期
     *
     * @param year
     * @param month
     * @return
     */
    public static String getLastDay(String year, String month) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.valueOf(year));
        cal.set(Calendar.MONTH, Integer.valueOf(month) - 1);
        int a = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, a);
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
        return sfd.format(cal.getTime());
    }

    /**
     * 两个时间之间相差距离多少天
     *
     * @param str1 时间参数 1：
     * @param str2 时间参数 2：
     * @return 相差天数
     */
    public static long getDistanceDays(String str1, String str2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date one;
        Date two;
        long days = 0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff = time2 - time1;
            days = diff / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }
}
