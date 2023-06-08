package com.sumvibe.springboot.utils;

/**
 * <P>修订记录：
 * <P>	2013-4-22下午4:22:07  wpq3375  创建
 * <p>
 * <P>功能描述：
 * <P>	日期时间格式
 */
public enum DateFormatPattern {

    /**
     * default date : "yyyy-M-d"
     */
    DEFAULT_DATE("yyyy-M-d"),

    /**
     * default date : "yyyy-M-d"
     */
    SIMPLE_DATE("yyyy-M-d"),
    /**
     * en date : "M-d-yyyy"
     */
    EN_DATE("M/d/yyyy"),

    /**
     * default full date : "yyyy-MM-dd"
     */
    DEFAULT_FULL_DATE("yyyy-MM-dd"),

    /**
     * default full date : "yyyyMMdd"
     */
    DEFAULT_FULL_DATE_NO_PARTITION("yyyyMMdd"),

    /**
     * default full date : "YYYYMMDD"
     */
    DEFAULT_FULL_DATE_NO_PARTITION_DB("YYYYMMDD"),

    /**
     * default full time : "HH24:MI:ss"
     */
    DEFAULT_FULL_TIME("HH24:MI:ss"),

    /**
     * default full time : "HHmmss"
     */
    DEFAULT_FULL_TIME_NO_PARTITION("HHmmss"),
    /**
     * default full time : "HH:mm:ss"
     */
    DEFAULT_FULL_TIME_NO_PARTITIONS("HH:mm:ss"),
    /**
     * default full timestamp : "yyyy-MM-dd HH:mm:ss"
     */
    DEFAULT_FULL_TIMESTAMP("yyyy-MM-dd HH:mm:ss"),

    /**
     * default full timestamp : "yyyy-MM-dd HH:mm:ss.SSS"
     */
    DEFAULT_FULL_TIMESTAMP_SSS("yyyy-MM-dd HH:mm:ss.SSS"),

    /**
     * default full timestamp : "yyyy-MM-dd HH:mm"
     */
    DEFAULT_FULL_TIMESTAMP_NO_SECOND("yyyy-MM-dd HH:mm"),

    /**
     * default full timestamp : "yyyy-MM-dd HHmmss"
     */
    DEFAULT_FULL_TIMESTAMP_HALF_PARTITION("yyyy-MM-dd HHmmss"),

    /**
     * default full timestamp : "YYYY-MM-DD HH24:MI:SS"
     */
    DEFAULT_FULL_TIMESTAMP_DB("YYYY-MM-DD HH24:MI:SS"),

    /**
     * default full timestamp : "yyyyMMddHHmmss"
     */
    DEFAULT_FULL_TIMESTAMP_NO_PARTITION("yyyyMMddHHmmss"),

    /**
     * default full timestamp : "YYYYMMDDHH24MISS"
     */
    DEFAULT_FULL_TIMESTAMP_NO_PARTITION_DB("YYYYMMDDHH24MISS"),

    /**
     * default year : "yyyy"
     */
    DEFAULT_YEAR("yyyy"),

    /**
     * default month : "MM"
     */
    DEFAULT_MONTH("MM"),

    /**
     * formate ： "yyyyMM"
     */
    DEFAULT_YEAR_MONTH("yyyyMM"),

    /**
     * formate ： "yyyy-MM"
     */
    DEFAULT_YEAR_MONTH_PARTITION("yyyy-MM"),

    YEAR_MONTH_PARTITION("yyMM"),

    /**
     * year 后两位 : "yy"
     */
    YEAR_LAST2("yy"),
    /**
     * default_en_date:MM/dd/yyyy
     */
    DEFAULT_EN_DATE("MM/dd/yyyy"),
    /**
     * MM/dd/yyyy HH:mm:ss
     */
    DEFULT_EN_TIMESTAMP("MM/dd/yyyy HH:mm:ss"),

    /**
     * 东一区
     */
    EASY_ONE("1"),

    /**
     * 东二区
     */
    EASY_TWO("2"),

    /**
     * 东三区
     */
    EASY_THREE("3"),

    /**
     * 东四区
     */
    EASY_FOUR("4"),

    /**
     * 东五区
     */
    EASY_FIVE("5"),

    /**
     * 东六区
     */
    EASY_SIX("6"),

    /**
     * 东七区
     */
    EASY_SEVEN("7"),

    /**
     * 东八区
     */
    EASY_EIGHT("8"),

    /**
     * 东九区
     */
    EASY_NINE("9"),

    /**
     * 东十区
     */
    EASY_TEN("10"),

    /**
     * 东十一区
     */
    EASY_ELEVEN("11"),

    /**
     * 东十二区
     */
    EASY_TWELVE("12"),

    /**
     * 西一区
     */
    WEST_ONE("-1"),

    /**
     * 西二区
     */
    WEST_TWO("-2"),

    /**
     * 西三区
     */
    WEST_THREE("-3"),

    /**
     * 西四区
     */
    WEST_FOUR("-4"),

    /**
     * 西五区
     */
    WEST_FIVE("-5"),

    /**
     * 西六区
     */
    WEST_SIX("-6"),

    /**
     * 西七区
     */
    WEST_SEVEN("-7"),

    /**
     * 西八区
     */
    WEST_EIGHT("-8"),

    /**
     * 西九区
     */
    WEST_NINE("-9"),

    /**
     * 西十区
     */
    WEST_TEN("-10"),

    /**
     * 西十一区
     */
    WEST_ELEVEN("-11"),

    /**
     * 西十二区
     */
    WEST_TWELVE("-12");

    private String pattern;

    private DateFormatPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

}

