package com.sumvibe.springboot.utils;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * <P>修订记录：
 * <P>	2013-4-22下午4:22:07  wpq3375  创建
 * <p>
 * <P>功能描述：
 * <P>	日期时间UTIL类
 * 常用日期操作.
 * toStringCurrentTimestamp() = 2008-07-29 16:39:44
 * toStringCurrentTimestampNoPartition() = 20080729163944
 * toStringCurrentDate() = 2008-07-29
 * toStringCurrentDateFirstDay() = 2008-07-01
 * toStringCurrentDateBeforMonth() = 2008-06-29
 * toStringCurrentDateBeforMonth() = 2008-06-29
 * toStringCurrentDateNoPartition() = 20080729
 * toStringCurrentYearMonth() = 200808
 * toStringCurrentDateWithLineToDB() = TO_DATE('2008-07-29', 'YYYY-MM-DD');
 * toStringCurrentDateToDB() =  TO_DATE('20080729', 'YYYYMMDD')
 * toStringCurrentDateTimeToDB() =  TO_DATE('20080729163944', 'YYYYMMDDHH24MISS')
 * toStringCurrentTimeStampToDB() =  TO_DATE('2008-07-29 16:39:44', 'YYYY-MM-DD HH24:MI:SS')
 */
public class DateUtils {

    private static Calendar calendar = Calendar.getInstance();
    private static final String LONG_REGEX = "^\\d+$";

    /**
     * 获取当前时间戳的String格式 [yyyy-MM-dd HH:mm:ss].
     *
     * @return String [yyyy-MM-dd HH:mm:ss]格式的当前时间
     */
    public static String toStringCurrentTimestamp() {
        return DateFormater.formatDate(getCurrentDate(), DateFormatPattern.DEFAULT_FULL_TIMESTAMP);
    }

    /**
     * @return String [yyyy-MM-dd HH:mm:ss]格式的指定时间
     * @author st-wg-lzb3938
     * 获取指定时间戳的String格式 [yyyy-MM-dd HH:mm:ss].
     */
    public static String toStringDate(Date d) {
        return DateFormater.formatDate(d, DateFormatPattern.DEFAULT_FULL_TIMESTAMP);
    }

    /**
     * @return String [yyyy-MM-dd HH:mm:ss]格式的指定时间
     * @author st-wg-lzb3938
     * 获取指定时间戳的String格式 [yyyy-MM-dd HH:mm:ss].
     */
    public static String toStringAfterHourDate(int hours) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getCurrentDate());
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return DateFormater.formatDate(calendar.getTime(), DateFormatPattern.DEFAULT_FULL_TIMESTAMP);
    }


    /**
     * 获取当前时间戳的String格式 [yyyyMMddHHmmss].
     *
     * @return String [yyyyMMddHHmmss]格式的当前时间
     */
    public static String toStringCurrentTimestampNoPartition() {
        return DateFormater.formatDate(getCurrentDate(), DateFormatPattern.DEFAULT_FULL_TIMESTAMP_NO_PARTITION);
    }


    /**
     * 获取特定时间的时间戳
     *
     * @return String [yyyyMMddHHmmss]格式的当前时间
     */
    public static String toStringTimestampNoPartition(Date date, DateFormatPattern pattrn) {
        return DateFormater.formatDate(date, pattrn);
    }

    /**
     * @return String [yyyy-MM-dd HH:mm:ss]格式的指定时间
     * @throws ParseException
     * @author st-wg-lzb3938
     * 获取指定时间戳的String格式 [yyyyMMddHHmmss].转成[yyyy-MM-dd HH:mm:ss]
     */
    public static String stringToStringDate(String d) throws ParseException {
        return DateFormater.parseDate(d, DateFormatPattern.DEFAULT_FULL_TIMESTAMP);
    }

    /**
     * 获取当前日期的String格式 [yyyy-MM-dd].
     *
     * @return String [yyyy-MM-dd]格式的当前时间
     */
    public static String toStringCurrentDate() {
        return DateFormater.formatDate(getCurrentDate(), DateFormatPattern.DEFAULT_FULL_DATE);
    }

    /**
     * 获取当前日期的String格式 [yyyyMMdd].
     *
     * @return String [yyyyMMdd]格式的当前时间
     */
    public static String toStringDateFull(Date date) {
        return DateFormater.formatDate(date, DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 获取当前日期的String格式 [yyyy-MM-dd].
     *
     * @return String [yyyy-MM-dd]格式的当前时间
     */
    public static String toStringCurrentDateSSS() {
        return DateFormater.formatDate(getCurrentDate(), DateFormatPattern.DEFAULT_FULL_TIMESTAMP_SSS);
    }

    /**
     * 获取当前日期的String格式 [yyyy-MM-dd].
     *
     * @return String [yyyy-MM-dd]格式的当前时间
     */
    public static String toStringCurrentDateCN(Date date) {
        String dateTime = DateFormater.formatDate(date, DateFormatPattern.DEFAULT_FULL_DATE);
        return  dateTime.replaceFirst("-","年").replace("-","月")+"日";
    }

    /**
     * 根据语言来显示日期格式
     * 获取当前日期的String格式 中文：[yyyy-MM-dd]；英文：[MM-dd-yyyy]
     *
     * @return String [yyyy-MM-dd]格式的当前时间
     */
    public static String toStringCurrentDate(String langId) {
        if (langId.equals(ConstValues.SYS_LANG_ZH_CN)) {//中文
            return DateFormater.formatDate(getCurrentDate(), DateFormatPattern.DEFAULT_FULL_DATE);
        } else {//英文
            return DateFormater.formatDate(getCurrentDate(), DateFormatPattern.EN_DATE);
        }

    }

    /**
     * 根据语言来显示日期格式
     * 获取当地日期的String格式 中文：[yyyy-MM-dd]；英文：[MM-dd-yyyy]
     *
     * @return String [yyyy-MM-dd]格式的当前时间
     */


    /**
     * 获取当前日期的当月的第一天String格式 [yyyy-MM-dd].
     *
     * @return String
     */
    public static String toStringCurrentDateFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        return DateFormater.formatDate(calendar.getTime(), DateFormatPattern.DEFAULT_FULL_DATE);
    }

    /**
     * 获取当前日期的n月之前的第一天String格式 [yyyy-MM-dd].
     * @param month 多少月之前
     * @return
     */
    public static String toStringBeforeDateFirstDay(int month) {
        Calendar calendar = Calendar.getInstance();
        if(calendar.get(Calendar.MONTH) > month){
            calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH) - month,1);
        }else{
            calendar.set(calendar.get(Calendar.YEAR) - 1,calendar.get(Calendar.MONTH) + 12 - month,1);
        }
        return DateFormater.formatDate(calendar.getTime(), DateFormatPattern.DEFAULT_FULL_DATE);
    }

    /**
     * 获取当前日期的n月之前的第一天String格式 [yyyy-MM-dd].
     * @param month 多少月之前
     * @return date
     */
    public static Date getbeforeDateFirstDay(int month) {
        Calendar calendar = Calendar.getInstance();
        if(calendar.get(Calendar.MONTH) > month){
            calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH) - month,1);
        }else{
            calendar.set(calendar.get(Calendar.YEAR) - 1,calendar.get(Calendar.MONTH) + 12 - month,1);
        }
        return calendar.getTime();
    }

    /**
     * 获取当前日期的n天之后的String格式 [yyMM].
     * @param day n天以后
     * @return date
     */
    public static String getbeforeDateToString(long day) {

        //return toStringCurrentDateCN(new Date(System.currentTimeMillis() + day * 24 * 60 * 60 * 1000));
        return toStringYearMonth(new Date(System.currentTimeMillis() + day * 24 * 60 * 60 * 1000));
    }

    /**
     * 获取当前日期的前一天的String格式 [yyyy-MM-dd].
     *
     * @return String
     */
    public static String toStringCurrentDateBeforeDate() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DATE, -1);
        return DateFormater.formatDate(calendar1.getTime(), DateFormatPattern.DEFAULT_FULL_DATE);
    }
    /**
     * 获取当前日期的前n天的String格式 [yyyy-MM-dd].
     *
     * @return String
     */
    public static String toStringCurrentDateBeforeSomeDay(int n) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DATE, -n);
        return DateFormater.formatDate(calendar1.getTime(), DateFormatPattern.DEFAULT_FULL_DATE);
    }
    /**
     * 获取当前日期的后n天的String格式 [yyyy-MM-dd HH:mm:ss].
     *
     * @return String
     */
    public static String toStringCurrentDateAfterSomeDay(int n) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DATE, n);
        return DateFormater.formatDate(calendar1.getTime(), DateFormatPattern.DEFAULT_FULL_TIMESTAMP);
    }

    /**
     * 获取当前日期的后一天的String格式 [yyyyMMdd].
     * h后一天1 前一天-1
     * @return String
     */
    public static String toStringCurrentDateAfterDate(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, day);
        return DateFormater.formatDate(calendar.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 获取指定日期的后一天字符串日期
     */
    public static String getSpecifiedDayAfter(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, 1);
        return DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 获取指定日期的上一月1号的字符串日期
     * specifiedDay：参数格式：yyyyMMdd
     */
    public static String getSpecifiedDayBeforeMonthFirstDay(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.set(Calendar.DATE, 1);//设定指定日期的所在月的1号
        c.add(Calendar.MONTH, -1);//获得上一月1号
        return DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 获取当前日期的前N个月的字符串日期
     * specifiedDay：参数格式：yyyy-MM-dd
     */
    public static String getSpecifiedDayBeforeNMonthDay(int n) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -n);//获得上一月1号
        return DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE);
    }

    /**
     * 获取当前日期的前N个月的字符串日期
     * specifiedDay：参数格式：yyyy-MM-dd
     */
    public static String getSpecifiedDayBeforeNDay(int n) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, -n);//获得上一月1号
        return DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE);
    }

    /**
     * 获取指定时间戳的String格式 [yyyy-MM-dd HH:mm:ss].
     *
     * @param date
     * @return [yyyy-MM-dd HH:mm:ss]格式的当前时间
     */
    public static String formatDate(Date date) {
        return DateFormater.formatDate(date, DateFormatPattern.DEFAULT_FULL_TIMESTAMP);
    }

    /**
     * 获取当前日期的前N个月的字符串日期
     * specifiedDay：参数格式：yyyy-MM-dd
     */
    public static String getSpecifiedDayBeforeNDay(int n, String langId) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, -n);//获得上一月1号
        if (langId.equals(ConstValues.SYS_LANG_ZH_CN)) {
            return DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE);
        } else {
            return DateFormater.formatDate(c.getTime(), DateFormatPattern.EN_DATE);
        }

    }

    /**
     * 获取当地日期的前N个月的字符串日期
     * specifiedDay：参数格式：yyyy-MM-dd
     */
    public static String getSpecifiedDayBeforeNDay(Date date, int n, String langId) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, -n);//获得上一月1号
        if (langId.equals(ConstValues.SYS_LANG_ZH_CN)) {
            return DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE);
        } else {
            return DateFormater.formatDate(c.getTime(), DateFormatPattern.EN_DATE);
        }

    }

    /**
     * 获取指定日期的上N月的字符串日期
     * specifiedDay：参数格式：yyyy-MM-dd
     */
    public static String getSpecifiedDayBeforeNMonthDay(String specifiedDay, int n) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.add(Calendar.MONTH, -n);//获得上一月1号
        return DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 获取指定日期的所在月1号的字符串日期
     * specifiedDay：参数格式：yyyyMMdd
     */
    public static String getSpecifiedDayCurrentMonthFirstDay(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);//设定指定日期的所在月的1号
        return DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 获取指定日期的所在月月最后一天的字符串日期
     * specifiedDay：参数格式：yyyyMMdd
     */
    public static String getSpecifiedDayCurrentMonthLastDay(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));//设定指定日期的所在月的1号
        return DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 获取当前系统时间所在月的1号
     * retrun 格式：yyyyMMdd
     */
    public static String getCurrentMonthFirstDay() {
        Calendar c = Calendar.getInstance();
        Date date = new Date();
        c.setTime(date);
        c.set(Calendar.DATE, 1);//设定指定日期的所在月的1号
        return DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 获取当前系统时间所在月的1号
     * retrun 格式：yyyyMMdd
     */
    public static String getThisDateToString(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 获取指定日期的上一月最后一天的字符串日期
     * specifiedDay：参数格式：yyyyMMdd
     */
    public static String getSpecifiedDayBeforeMonthEndDay(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.set(Calendar.DATE, 1);//设定指定日期的所在月的1号
        c.add(Calendar.DAY_OF_YEAR, -1);//获得上一月最后一天
        return DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 获取指定日期的下一月所在的的字符串日期
     * specifiedDay：参数格式：yyyyMMdd
     */
    public static String getSpecifiedDayAfterMonthCurrentDay(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.add(Calendar.MONTH, 1);//获得上一月最后一天
        return DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 获取指定日期的上一年第一天的字符串日期
     * specifiedDay：参数格式：yyyyMMdd
     */
    public static String getSpecifiedDayBeforeYearFistDay(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.add(Calendar.YEAR, -1);//获得上一年最后一天
        String bd = DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);

        return bd.substring(0, 4) + "0101";
    }

    /**
     * 获取指定日期的所在年的第一天的字符串日期
     * specifiedDay：参数格式：yyyyMMdd
     */
    public static String getSpecifiedDayCurrentYearFistDay(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.set(Calendar.DAY_OF_YEAR, 1);//获得本年第一天
        String bd = DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);

        return bd;
    }

    /**
     * 获取指定日期的所在年最后一天的字符串日期
     * specifiedDay：参数格式：yyyyMMdd
     */
    public static String getSpecifiedDayCurrentYearLastDay(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.set(Calendar.DAY_OF_YEAR, c.getActualMaximum(Calendar.DAY_OF_YEAR));
        String bd = DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);

        return bd;
    }

    /**
     * 获取指定日期的上一年第一天的字符串日期
     * specifiedDay：参数格式：yyyyMMdd
     */
    public static String getSpecifiedDayBeforeYearLastDay(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.add(Calendar.YEAR, -1);//获得上一月最后一天
        String bd = DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);

        return bd.substring(0, 4) + "1231";
    }

    /**
     * 获取当前日期的后7天的String格式 [yyyyMMdd].
     *
     * @return String
     */
    public static String toStringCurrentDateAfterWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        return DateFormater.formatDate(calendar.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 获取指定日期的后7天的String格式 [yyyyMMdd].
     *
     * @return String
     */
    public static String toStringSpecifiedDateAfterWeek(String specifiedDay) {
        Date date = null;
        Calendar calendar = Calendar.getInstance();
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        return DateFormater.formatDate(calendar.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 根据根据指定日期获取上周周一日期
     *
     * @param specifiedDay:指定日期
     * @return String
     */
    public static String getBeforWeekFirstOfSepciedDay(String specifiedDay) {
        Date date = null;
        Calendar calendar = Calendar.getInstance();
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.DAY_OF_YEAR, -7);
//		int w = calendar.get(Calendar.WEEK_OF_YEAR);
        return DateFormater.formatDate(calendar.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 根据根据指定日期获取上周周日日期
     *
     * @param specifiedDay:指定日期
     * @return String
     */
    public static String getBeforWeekLastOfSepciedDay(String specifiedDay) {
        Date date = null;
        Calendar calendar = Calendar.getInstance();
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
//		int w = calendar.get(Calendar.WEEK_OF_YEAR);
        return DateFormater.formatDate(calendar.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 根据根据指定日期获取本周周一日期
     *
     * @param specifiedDay:指定日期
     * @return String
     * @author kym4107
     */
    public static String getWeekMondayOfSepciedDay(String specifiedDay) {
        Date date = null;
        Calendar calendar = Calendar.getInstance();
        try {
            if (DateUtils.getWeekByDate(DateUtils
                    .getDefaultFullDateNoPartition(specifiedDay)) == 0) {
                //在此基础上减7，在java中是已周日为第一天周六为最后一天
                Date dspecifiedDay = DateUtils.getDefaultFullDateNoPartition(specifiedDay);
                dspecifiedDay = DateUtils.addDate(dspecifiedDay, -7);
                specifiedDay = DateUtils.toStringTimestampNoPartition(dspecifiedDay,
                        DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
            }
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (Exception e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        //calendar.add(Calendar.DAY_OF_YEAR, -7);
//		int w = calendar.get(Calendar.WEEK_OF_YEAR);
        return DateFormater.formatDate(calendar.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 根据根据指定日期获取本周周日日期
     *
     * @param specifiedDay:指定日期
     * @return String
     * @author kym4107
     */
    public static String getWeekSundayOfSepciedDay(String specifiedDay) {
        Date date = null;
        Calendar calendar = Calendar.getInstance();
        try {
            if (DateUtils.getWeekByDate(DateUtils
                    .getDefaultFullDateNoPartition(specifiedDay)) == 0) {
                //在此基础上减7，在java中是已周日为第一天周六为最后一天
                Date dspecifiedDay = DateUtils.getDefaultFullDateNoPartition(specifiedDay);
                dspecifiedDay = DateUtils.addDate(dspecifiedDay, -7);
                specifiedDay = DateUtils.toStringTimestampNoPartition(dspecifiedDay,
                        DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
            }
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (Exception e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return DateFormater.formatDate(calendar.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 获取当前日期的前一个月的String格式 [yyyy-MM-dd].
     *
     * @return String
     */
    public static String toStringCurrentDateBeforMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);

        return DateFormater.formatDate(calendar.getTime(), DateFormatPattern.DEFAULT_FULL_DATE);
    }

    /**
     * 将格式为yyyy-MM-dd字符串日期转化为 yyyyMMdd格式的字符串日期
     * specifiedDay：参数格式：yyyy-MM-dd
     * retrun :格式 yyyyMMdd
     */
    public static String getSpecifiedDayToStringDay(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        return DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 将格式为yyyy-MM-dd字符串日期转化为 yyyyMMdd格式的字符串日期
     * specifiedDay：参数格式：yyyy-MM-dd
     * retrun :格式 yyyyMMdd
     */
    public static String getSpecifiedDayToStringDay(String specifiedDay, String langId) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            if (langId.equals(ConstValues.SYS_LANG_ZH_CN)) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
            } else {
                date = new SimpleDateFormat("M/d/yyyy").parse(specifiedDay);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        return DateFormater.formatDate(c.getTime(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 获取当前日期的前几个月的String格式 [yyyy-MM-dd].
     *
     * @param amount
     * @return String
     */
    public static String toStringCurrentDateBeforMonth(int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, amount);

        return DateFormater.formatDate(calendar.getTime(), DateFormatPattern.DEFAULT_FULL_DATE);
    }

    /**
     * 获取当前日期的String格式 [yyyyMMdd].
     *
     * @return String
     */
    public static String toStringCurrentDateNoPartition() {
        return DateFormater.formatDate(getCurrentDate(), DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 获取当前时间的String格式 [HHmmss].
     *
     * @return String
     */
    public static String toStringCurrentTimeNoPartition() {
        return DateFormater.formatDate(getCurrentDate(), DateFormatPattern.DEFAULT_FULL_TIME_NO_PARTITION);
    }

    /**
     * 获取当前时间的String格式 [HH:mm:ss].
     *
     * @return String
     */
    public static String toStringCurrentTimeNoPartitions() {
        return DateFormater.formatDate(getCurrentDate(), DateFormatPattern.DEFAULT_FULL_TIME_NO_PARTITIONS);
    }

    /**
     * 获取可以<b>直接写入 DB Date 类型</b>的当前日期字串 ：[ <b>TO_DATE('2008-07-29', 'YYYY-MM-DD')</b> ].
     *
     * @return String
     */
    public static String toStringCurrentDateWithLineToDB() {
        return toStringDateToDB(DateFormater.formatDate(getCurrentDate()),
                DateFormatPattern.DEFAULT_FULL_DATE);
    }

    /**
     * 获取可以<b>直接写入 DB Date 类型</b>的当前日期字串 ：[ <b>TO_DATE('20071212', 'YYYYMMDD')</b> ].
     *
     * @return String
     */
    public static String toStringCurrentDateToDB() {

        return toStringDefaultFullNoPatitionDateToDB(DateFormater.formatDate(getCurrentDate(),
                DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION));
    }

    /**
     * 获取可以<b>直接写入 DB DateTime 类型</b>的当前日期字串 ：[ <b>TO_DATE('20071212010101', 'YYYYMMDDHH24MISS')</b> ].
     *
     * @return String
     */
    public static String toStringCurrentDateTimeToDB() {

        return toStringDefaultFullNoPatitionDateTimeToDB(DateFormater.formatDate(getCurrentDate(),
                DateFormatPattern.DEFAULT_FULL_TIMESTAMP_NO_PARTITION));
    }


    /**
     * 根据匹配 ['yyyyMMddHH24MIss']格式的日期字串, 获取可以直接写入 DB DateTime 类型的字串 ：[ <b>TO_DATE('20071212010101', 'YYYYMMDDHH24MISS')</b> ].
     *
     * @param date 匹配 ['yyyyMMddHH24MIss']格式的日期字串
     * @return String
     */
    private static String toStringDefaultFullNoPatitionDateTimeToDB(String date) {
        return toStringDateToDB(date, DateFormatPattern.DEFAULT_FULL_TIMESTAMP_NO_PARTITION_DB);
    }

    /**
     * 获取可以<b>直接写入 DB DateTime 类型</b>的当前日期字串 ：[ <b>TO_DATE('2007-12-12 10:10:11', 'YYYY-MM-DD HH24:MI:SS')</b> ].
     *
     * @return String
     */
    public static String toStringCurrentTimeStampToDB() {

        return toStringDefaultFullTimeStampToDB(DateFormater.formatDate(getCurrentDate(),
                DateFormatPattern.DEFAULT_FULL_TIMESTAMP));
    }

    /**
     * 根据匹配 ['yyyy-MM-dd HH24:MI:ss']格式的日期字串, 获取可以直接写入 DB Date 类型的字串 ：[ <b>TO_DATE('2007-12-12 10:10:11', 'YYYY-MM-DD HH24:MI:SS')</b> ].
     *
     * @param date 匹配 ['yyyy-MM-dd HH24:MI:ss']格式的日期字串
     * @return String
     */
    private static String toStringDefaultFullTimeStampToDB(String date) {
        return toStringDateToDB(date, DateFormatPattern.DEFAULT_FULL_TIMESTAMP_DB);
    }

    /**
     * 根据匹配 ['yyyy-MM-dd HH:mm:ss.SSSSSS']格式的日期字串, 获取可以直接写入 DB Date 类型的当前时间字串
     *
     * @return String
     */
    public static String toStringCurrentSysTimestampToDBByNanoSeconds() {
        return " TO_CHAR(SYSTIMESTAMP,'YYYY-MM-DD HH24:MI:SS.FF6') ";
    }

    /**
     * 根据匹配 ['yyyyMMdd']格式的日期字串, 获取可以直接写入 DB Date 类型的字串 ：[ <b>TO_DATE('20071212', 'YYYYMMDD')</b> ].
     *
     * @param date 匹配 ['yyyyMMdd']格式的日期字串
     * @return String
     */
    private static String toStringDefaultFullNoPatitionDateToDB(String date) {
        return toStringDateToDB(date, DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION_DB);
    }

    /**
     * 根据相互匹配的日期字串与格式获取可以直接写入 DB Date/DateTime 类型的日期字串，eg [ <b>TO_DATE('20071212', 'YYYYMMDD')</b> ].
     *
     * @param date    与 pattern 匹配的日期字串
     * @param pattern 与 date 匹配的日期格式
     * @return String
     */
    private static String toStringDateToDB(String date, DateFormatPattern pattern) {

        if (date == null) {
            return "''";
        }

        return new StringBuilder().append(" TO_DATE('")
                .append(date)
                .append("', '")
                .append(pattern.getPattern())
                .append("')")
                .toString();
    }

    /**
     * 获取当前年份的后两位.
     *
     * @return String
     */
    public static String toStringCurrentYearLast2() {
        return DateFormater.formatDate(getCurrentDate(), DateFormatPattern.YEAR_LAST2);
    }

    /**
     * 获取当前日期的String格式 [yyyyMM].
     *
     * @return String
     */
    public static String toStringCurrentYearMonth() {
        return DateFormater.formatDate(getCurrentDate(), DateFormatPattern.DEFAULT_YEAR_MONTH);
    }

    /**
     * yyMM格式
     * @param date
     * @return
     */
    public static String toStringYearMonth(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyMM");
        return formatter.format(date);

    }

    public static String toStringYear2Month(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, month);
        return DateFormater.formatDate(calendar.getTime(), DateFormatPattern.YEAR_MONTH_PARTITION);
    }

    /**
     * 获取当前日期的String格式 [yyyy].
     *
     * @return String
     */
    public static String toStringCurrentYear() {
        return DateFormater.formatDate(getCurrentDate(), DateFormatPattern.DEFAULT_YEAR);
    }

    /**
     * 获取当先系统日期
     *
     * @return Date
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 根据日期格式为 ["yyyyMMdd"] 的日期字串 获取 date.
     *
     * @param date 与 "yyyyMMdd" 匹配的日期字串
     * @return Date
     * @throws Exception
     */
    public static Date getDefaultFullDateNoPartition(String date) throws Exception {
        return getDate(date, DateFormatPattern.DEFAULT_FULL_DATE_NO_PARTITION);
    }

    /**
     * 根据日期格式为 ["yyyy-MM-dd"] 的日期字串 获取 date.
     *
     * @param date 与 "yyyy-MM-dd" 匹配的日期字串
     * @return Date
     * @throws Exception
     */
    public static Date getDefaultFullDate(String date) throws Exception {
        return getDate(date, DateFormatPattern.DEFAULT_FULL_DATE);
    }

    /**
     * 根据相互匹配的日期字串与格式获取 date.
     *
     * @param date    与 pattern 匹配的日期字串
     * @param pattern 与 date 匹配的日期格式
     * @return Date
     * @throws Exception
     */
    public static Date getDate(String date, DateFormatPattern pattern) throws NullPointerException, ParseException {
        if (date == null || date.length() == 0) {
            return null;
        }
        return new SimpleDateFormat(pattern.getPattern()).parse(date);
    }

    /**
     * 增加日期天数,
     *
     * @param date:日期 i:增加天数
     * @return Date
     */
    public static Date addDate(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, i);
        date = calendar.getTime();
        return date;
    }


    /**
     * 根据日期和时区,转换成东八区时间,如果时区是空值时默认日期是东八区时间
     *
     * @param date-日期
     * @param timeZone 时区(东八区8，西八区-8)
     * @return Date
     */
    public static Date changeDateByTimeZone(Date date, String timeZone) {
        //如果时区非空则根据时区转换东八区时间
        if (null != timeZone && !"".equals(timeZone)) {
            //时区计算-8
            date = DateUtils.addday(date, Integer.parseInt(timeZone) - 8);
        }
        return date;
    }


    /**
     * 时区转换
     *
     * @param date           转换前时区对应的时间
     * @param sourceTimeZone 转换前时区
     * @param targetTimeZone 转换后时区
     * @return 转换后的时间
     */
    public static Date changeTimeZone(Date date, String sourceTimeZone, String targetTimeZone) {

        int source = Integer.parseInt(sourceTimeZone);
        int target = Integer.parseInt(targetTimeZone);

        return addday(date, target - source);
    }

    /**
     * 时区转换-将东8区时间转换为目标时区时间
     *
     * @param date           东8区时间
     * @param targetTimeZone 转换后时区
     * @return 目标时区对应时间
     */
    public static Date changeTimeZoneFromGMT8(Date date, String targetTimeZone) {
        return changeTimeZone(date, DateFormatPattern.EASY_EIGHT.getPattern(), targetTimeZone);
    }

    /**
     * 时区转换-将目标时区时间转换为东8区时间
     *
     * @param date           转换前时区对应的时间
     * @param sourceTimeZone 目标时区
     * @return 东8区时间
     */
    public static Date changeTimeZoneToGMT8(Date date, String sourceTimeZone) {
        return changeTimeZone(date, sourceTimeZone, DateFormatPattern.EASY_EIGHT.getPattern());
    }


    /**
     * 计算 日期 calendar1 与 calendar2 之间的所查的天数 ,注：return calendar1 - calendar2
     *
     * @param calendar1 日期1
     * @param calendar2 日期2
     * @return 相差天数 = 日期1 - 日期2
     */
    public static int dateSubtraction(Calendar calendar1, Calendar calendar2) {
        long daterange = calendar1.getTime().getTime()
                - calendar2.getTime().getTime();
        long time = 1000 * 3600 * 24;

        return (int) (daterange / time);
    }


    /**
     * 判断输入日期是否合法
     *
     * @param strInput 输入日期字符串 yyyyMMdd
     * @return 合法，<code>true</code>；非法，<code>false</code>
     */
    public static boolean isDateValid(String strInput) {
        if (strInput == null) return false;
        String strTmp;
        if (strInput.length() != 8) {
            return false;
        }
        if (isDigital(strInput) == false) {
            return false;
        }

        int iYear;
        strTmp = strInput.substring(0, 4);
        iYear = Integer.parseInt(strTmp);
        int iMonth;
        strTmp = strInput.substring(4, 6);
        iMonth = Integer.parseInt(strTmp);

        if (iMonth > 12 || iMonth < 1) {
            return false;
        }
        int iDay;
        strTmp = strInput.substring(6, 8);
        iDay = Integer.parseInt(strTmp);
        switch (iMonth) {
            case 4:
            case 6:
            case 9:
            case 11:
                if (iDay > 30) {
                    return false;
                }
                break;
            case 2:
                if (iYear % 400 == 0 || (iYear % 100 != 0 && iYear % 4 == 0)) {
                    if (iDay > 29) {
                        return false;
                    }
                } else if (iDay > 28) {
                    return false;
                }
            default: {

            }
        }
        if (iDay > 31 || iDay < 1) {
            return false;
        }
        return true;
    }

    /**
     * 判断输入字符串是否为数字字符串
     *
     * @param strInput 数字字符串
     * @return 是数字型，<code>true</code>；否则，<code>false</code>
     */
    static public boolean isDigital(String strInput) {
        int i;
        for (i = 0; i < strInput.length(); i++)
            if (strInput.charAt(i) > '9' || strInput.charAt(i) < '0')
                return (false);
        return (true);
    }

    /**
     * (当前日期精确到毫秒)
     *
     * @return (请在@param后补充参数的具体含义)
     * (请在@return后补充返回类型为：String)
     */
    public static String toStringCurrentDateTomillis() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return format.format(new Date());
    }

    /**
     * 根据输入日期格式得到当前日期是星期几
     *
     * @param date:日期格式
     * @return int 1-6代表周一至周六  0代表周日
     */
    public static int getWeekByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return w;
    }


    /**
     * 判断当前日期是否是周六或者周日
     *
     * @param date:日期格式
     * @return boolean 周六或者周日返回true否则返回false
     */
    public static boolean isWeekByDate(Date date) {
        boolean flag = false;
        if (getWeekByDate(date) == 0 || getWeekByDate(date) == 6) {
            return true;
        }
        return flag;
    }


    /**
     * 增加日期小时数
     *
     * @param date:日期 i:增加小时
     * @return Date
     */
    public static Date addday(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, i);
        date = calendar.getTime();
        return date;
    }


    /**
     * 根据日期和时区,将时间由东八区时间转换成指定时区时间,如果时区是空值时默认日期是东八区时间
     *
     * @param date-日期
     * @param timeZone 时区(东八区8，西八区-8)
     * @return Date
     * @author kym4107
     */
    public static Date changeDateFromEast8ToTimeZone(Date date, String timeZone) {
        //如果时区非空则根据时区转换东八区时间
        if (null != timeZone && !"".equals(timeZone)) {
            //时区计算-8
            date = DateUtils.addday(date, Integer.parseInt(timeZone) - 8);
        }
        return date;
    }


    /**
     * 获取在指定时区的当前时间
     *
     * @param
     * @return Date:指定时区的当前时间
     * @author kym4107
     */
    public static Date getOrgCurDate(String timeZone) {
        Date curDate = DateUtils.getCurrentDate();
        if (null != timeZone || !"".equals(timeZone)) {
            curDate = DateUtils.changeDateFromEast8ToTimeZone(curDate, timeZone);
        }
        return curDate;
    }

    /**
     * 将【yyyy-MM-dd HH:mm:ss】字符串日期转为Date
     *
     * @param
     * @return Date:指定时区的当前时间
     * @throws Exception
     * @author kym4107
     */
    public static Date getStringToDate(String d) throws Exception {
        return getDate(d, DateFormatPattern.DEFAULT_FULL_TIMESTAMP);
    }

    /**
     * 根据输入日期格式得到当前日期所在本年度周数
     *
     * @param date:日期格式
     * @return int 1-6代表周一至周六  0代表周日
     */
    public static int getWeekOfYearByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //kym4107新增设置周一为第一天
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int w = calendar.get(Calendar.WEEK_OF_YEAR);
        return w;
    }

    /**
     * 输入日期获取指定M个月后的日期
     *
     * @param date:日期格式
     * @return int 1-6代表周一至周六  0代表周日
     */
    public static String getsepcatialDateByDate(Date date, int m) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.setTime(date);
        calendar.add(Calendar.MARCH, m);
        return sdf.format(calendar.getTime());
    }

    /**
     * 计算 日期 date1 与 date2 之间的所相差的天数 ,
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return 相差天数 = 日期1 - 日期2
     */
    public static int dateSubtraction(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return 0;
        }

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar2.setTime(date2);
        return dateSubtraction(calendar1, calendar2);

    }


    /**
     * 计算时间距离0点的秒数
     *
     * @param date 时间点
     * @return 秒数
     * @throws Exception 抛出异常
     */
    public static String getZeroSeconds(Date date) throws Exception {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = sdf1.parse(sdf1.format(date));
        Date date2 = sdf2.parse(sdf2.format(date));

        long time = (date1.getTime() - date2.getTime()) / 1000;
        return String.valueOf(time);
    }

    public static Date getPTwoMonthDate(Date date) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONDAY, -2);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    public static Date getLTwoMonthDate(Date date) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 3);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return calendar.getTime();
    }



    /**
     * 获取年份
     * @param time
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static int getYear(String time, String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(pattern).parse(time));
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取月份
     * @param time
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static int getMonth(String time, String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(pattern).parse(time));
        return calendar.get(Calendar.MONTH) +  1;
    }

    /**
     * 获取当月的第几天
     * @param time
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static int getDayOfMonth(String time, String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(pattern).parse(time));
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取小时
     * @param time
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static int getHourOfDay(String time, String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(pattern).parse(time));
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取分钟
     * @param time
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static int getMinute(String time, String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(pattern).parse(time));
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 获取秒
     * @param time
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static int getSecond(String time, String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(pattern).parse(time));
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 获取周
     * @param time
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static int getWeek(String time, String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(pattern).parse(time));
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 根据时间戳获取年
     * @param time
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static int getYear(Timestamp time, String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(pattern).parse(new SimpleDateFormat(pattern).format(time)));
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 根据时间戳获取月份
     * @param time
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static int getMonth(Timestamp time, String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(pattern).parse(new SimpleDateFormat(pattern).format(time)));
        return calendar.get(Calendar.MONTH)+1;
    }

    /**
     * 根据时间戳获取天
     * @param time
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static int getDayOfMonth(Timestamp time, String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(pattern).parse(new SimpleDateFormat(pattern).format(time)));
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 根据时间戳获取小时
     * @param time
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static int getHourOfDay(Timestamp time, String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(pattern).parse(new SimpleDateFormat(pattern).format(time)));
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 根据时间戳获取分钟
     * @param time
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static int getMinute(Timestamp time, String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(pattern).parse(new SimpleDateFormat(pattern).format(time)));
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 根据时间戳获取秒
     * @param time
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static int getSecond(Timestamp time, String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(pattern).parse(new SimpleDateFormat(pattern).format(time)));
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 根据时间戳获取周
     * @param time
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static int getWeek(Timestamp time, String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(pattern).parse(new SimpleDateFormat(pattern).format(time)));
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 当前时间增加秒，返回时间戳长整型
     * @param second
     * @return
     */
    public static long addSeconds(int second){
        return System.currentTimeMillis() + second * 1000;
    }

    /**
     * 判断时间戳是否超过当前时间
     * @param timestamp
     * @return
     */
    public static boolean isTimeOut(String timestamp){
        if(timestamp.matches(LONG_REGEX)) {
            return System.currentTimeMillis() > Long.parseLong(timestamp);
        }
        return false;
    }

    /**
     * 休眠毫秒数
     * @param millisecond
     */
    public static void sleep(long millisecond){
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取当前时间字符串形式
     * @return
     */
    public static String nowTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static String nowTimestamp(){
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * 字符串转为date
     * @param time
     * @param pattern
     * @return
     */
    public static Date str2Date(String time, String pattern){
        try {
            return new SimpleDateFormat(pattern).parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Date转化为字符串，格式为pattern
     * @param date
     * @param pattern
     * @return
     */
    public static String date2Str(Date date, String pattern){
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * Date转化为字符串，默认格式为yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String date2Str(Date date){
        return date2Str(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 字符串时间戳转为long
     * @param timestamp
     * @return
     */
    public static long str2Timestamp(String timestamp){
        if(timestamp.matches(LONG_REGEX)) {
            return Long.parseLong(timestamp);
        }
        return 0;
    }

    public static Date timestamp2Date(String timestamp){
        return new Date(str2Timestamp(timestamp));
    }

    /**
     * 字符串转Date
     * @param time
     * @return
     */
    public static Date str2Date(String time){
        return str2Date(time, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当前十分秒时间戳字符串形式
     * @param time
     * @return
     */
    public static String getTime(String time){
        return String.valueOf(str2Date(time, "HH:mm:ss").getTime());
    }

    /**
     * 时间戳根据pattern转化为格式化时间格式
     * @param timestamp
     * @param pattern
     * @return
     */
    public static String timestamp2Str(long timestamp, String pattern){
        return date2Str(new Date(timestamp), pattern);
    }

    /**
     * 时间戳转化为格式化时间格式，默认格式yyyy-MM-dd HH:mm:ss
     * @param timestamp
     * @return
     */
    public static String timestamp2Str(long timestamp){
        return date2Str(new Date(timestamp));
    }

    /**
     * 比较两个日期十分秒
     * @param d1
     * @param d2
     * @return
     */
    public static int compare(Date d1, Date d2){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);

        if(cal1.get(Calendar.HOUR_OF_DAY) == cal2.get(Calendar.HOUR_OF_DAY)) {
            if (cal1.get(Calendar.MINUTE) == cal2.get(Calendar.MINUTE)) {
                return cal1.get(Calendar.SECOND) - cal2.get(Calendar.SECOND);
            }
            return cal1.get(Calendar.MINUTE) - cal2.get(Calendar.MINUTE);
        }
        return cal1.get(Calendar.HOUR_OF_DAY) - cal2.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取当前0点0分0秒的时间戳
     * @return
     */
    public static long getCurZeroTimestamp(){
        long current = System.currentTimeMillis();
        long zero = current/(1000*3600*24)*(1000*3600*24) - TimeZone.getDefault().getRawOffset();
        return zero;
    }

    /**
     * 判断时间是否合法 HH:mm:ss
     *
     */
    public static boolean isCorrectTimeFormat( String formatTime ){
        if( formatTime.length() == 5 ){
            formatTime += ":00";
        }
        if( isCorrectTimeFormat( formatTime, "HH:mm:ss")){
            return true;
        }

        return false;
    }

    /**
     * 判断时间是否合法 HH:mm:ss
     *
     */
    public static boolean isCorrectTimeFormat( String formatTime,String pattern ){
        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            format.parse( formatTime );
        }
        catch (ParseException e){
            return false;
        }
        return true;
    }
    /**
     * 当前时间增加多少分钟，返回Date类型
     * @param min  增加多少分钟
     * @return
     */
    public static Date localDateAddMins(int min){
        Date date = new Date();
        long s1 = date.getTime();
        long s2 = s1+min*60*1000;
        Date date2 = new Date();
        date2.setTime(s2);
        return date2;
    }

    public static String currentBill(Date billDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String day = simpleDateFormat.format(date);
        String billDay = simpleDateFormat.format(billDate);
        int dayNum = Integer.parseInt(day.substring(day.length()-2));
        System.out.println(dayNum);
        int billNum = Integer.parseInt(billDay.substring(billDay.length()-2));
        if ( dayNum > billNum ) {
            return day.substring(2,6);
        } else {
            return toStringYear2Month(-1);
        }
    }

    public static void main(String[] args) throws Exception{

        System.out.println(getSpecifiedDayBeforeNMonthDay(2));
    }

    /**
     * 格式化日期字符串并输出指定格式日期字符串
     * @param dateStr
     * @param inPattern
     * @param outPattern
     * @return
     * @throws Exception
     */
    public static String exchageDateStr(String dateStr,DateFormatPattern inPattern,DateFormatPattern outPattern) throws Exception{
        //格式化日期
        SimpleDateFormat sdf1 = new SimpleDateFormat(inPattern.getPattern());
        //输出指定日期字符串
        SimpleDateFormat sdf2 = new SimpleDateFormat(outPattern.getPattern());
        if(dateStr!=null&&dateStr!=""){
            Date inDate=sdf1.parse(dateStr);
            return sdf2.format(inDate);

        }else{
            return "";
        }

    }

    /**
     *将字符串格式yyyyMMdd的字符串转为日期，格式"yyyy-MM-dd"
     *
     * @param date 日期字符串
     * @return 返回格式化的日期
     * @throws ParseException 分析时意外地出现了错误异常
     */
    public static String strToDateFormat(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        formatter.setLenient(false);
        Date newDate= formatter.parse(date);
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(newDate);
    }
}
