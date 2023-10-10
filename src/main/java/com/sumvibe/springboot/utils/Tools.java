package com.sumvibe.springboot.utils;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <P>修订记录：
 * <p>
 * <P>	2014-8-22 下午14:20
 * <P> @author qfj3734
 * <P>功能描述：
 * <P>	工具类
 */
public class Tools {

    /**
     * 传入参数得到随机数
     *
     * @param length
     * @return
     */
    public static String randGen(int length) {
        SecureRandom secureRandom = null;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
            char numbers[] = "1234567890".toCharArray();
            if (length < 1) {
                return "";
            }
            char randBuffer[] = new char[length];
            for (int i = 0; i < randBuffer.length; i++) {
                randBuffer[i] = numbers[secureRandom.nextInt(9)];
            }
            return new String(randBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据当前日期生成编号YYYYMMDDHH24MISS+6位随机数
     *
     * @param caodeType
     * @return
     */
    public static String getDateNO(String caodeType) {
        String dateNo = caodeType + DateFormater.formatDate(new Date(), "yyyyMMddHHmmssSSS") + randGen(6);
        return dateNo;
    }

    /**
     * 获取uuid
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取大写uuid
     *
     * @return
     */
    public static String getUUIDUpperCase() {
        return getUUID().toUpperCase();
    }

    /**
     * 获取数字uuid
     *
     * @return
     */
    public static Long getUUIDNumber() {
        String orderNo;
        String trandNo = String.valueOf((Math.random() * 9 + 1));
        String sdf = new SimpleDateFormat("yyMMdd").format(new Date());
        orderNo = trandNo.substring(trandNo.length() - 12);
        orderNo = sdf + orderNo;
        return Long.valueOf(orderNo);
    }

    /**
     * 判断某个数组中是否存在某个字符串
     *
     * @param arrs 数组
     * @param str  字符串
     * @return
     */
    public static boolean ifExistStr(String[] arrs, String str) {
        for (String arr : arrs) {
            if (arr.equals(str)) return true;
        }
        return false;
    }

    /**
     * 将字符串转换为浏览器支持的编码 <响应头>
     *
     * @param request 请求
     * @param name    指定的字符串
     * @return 浏览器支持的编码方式的字符串
     * @throws UnsupportedEncodingException
     */
    public static String getCharacterEncodingStr(HttpServletRequest request, String name) throws UnsupportedEncodingException {
        //获得请求头中的User-Agent
        String agent = request.getHeader("User-Agent");
        String filenameEncoder;

        if (agent.contains("MSIE")) {
            // IE浏览器
            filenameEncoder = URLEncoder.encode(name, "utf-8");
            filenameEncoder = filenameEncoder.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filenameEncoder = "=?utf-8?DTO?"
                    + base64Encoder.encode(name.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filenameEncoder = URLEncoder.encode(name, "utf-8");
        }
        return filenameEncoder;
    }

    /**
     * 首字母变小写
     *
     * @param str
     * @return
     */
    public static String formatStr(String str) {
        byte[] bytes = str.getBytes();
        if (bytes[0] > 90 || bytes[0] < 65) return str;
        bytes[0] = (byte) (bytes[0] + 32);
        return new String(bytes);
    }

    /**
     * 生成指定位随机字符串 纯数字
     *
     * @param length 长度
     * @return
     */
    public static String getRandomNum(int length) {
        String numStr = "";
        for (int i = 0; i < length; i++) {
            numStr += (int) (Math.random() * 10);
        }
        return numStr;
    }

    /**
     * 格式化数字，
     *
     * @param d           值
     * @param samllLength 保留几位小数
     * @param delSum      删除后几位后在执行格式化
     * @return
     */
    public static String formatNbr(Long d, int samllLength, int delSum) {
        String s = "";
        if (d.toString().length() < (samllLength + delSum + 1)) {
            for (int i = 0; i < ((samllLength + delSum + 1) - d.toString().length()); i++) {
                s += "0";
            }
            s += d.toString();
        } else {
            s = d.toString();
        }
        s = s.substring(0, s.length() - delSum);
        StringBuffer str = new StringBuffer(s);
        str.insert(s.length() - samllLength, ".");
        return str.toString();
    }

    /**
     * 格式化折扣
     *
     * @param linfee 折扣值
     * @return
     */
    public static String formatFee(double linfee) {
        long ceil = (long) Math.ceil(linfee * 100);
        long num = ceil / 10;
        long rem = ceil % 10;
        if (rem > 7) {
            ceil = (num + 1) * 10;
        } else if (rem >= 3) {
            ceil = num * 10 + 5;
        } else {
            ceil = num * 10;
        }
        if (ceil >= 100) return "无折扣";
        return formatNbr(ceil, 1, 0) + "折";
    }


    public static String formatFee2(long linfee) {
        if (linfee == 0) return "无折扣";
        return formatNbr(linfee, 1, 0) + "折";
    }

    /**
     * 字符串转unicode
     *
     * @param str
     * @return
     */
    public static String stringToUnicode(String str) throws Exception {
        StringBuffer sb = new StringBuffer();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            sb.append("\\u" + Integer.toHexString(c[i]));
        }
        return sb.toString();
    }

    /**
     * unicode转字符串
     *
     * @param unicode
     * @return
     */
    public static String unicodeToString(String unicode) throws Exception {
        StringBuilder sb = new StringBuilder();
        String[] hex = unicode.split("\\\\u");
        if (hex.length < 2) return unicode;
        sb.append(hex[0]);
        for (int i = 1; i < hex.length; i++) {
            String hex1 = hex[i];
            String end = "";
            if (hex1.contains("<")) {
                end = hex1.substring(hex1.indexOf("<"));
                hex1 = hex1.replaceAll(end, "");
            }
            if (!"".equals(hex1)) {
                int index = Integer.parseInt(hex1, 16);
                sb.append((char) index);
            }
            sb.append(end);
        }
        return sb.toString();
    }

    public static String unicodeToString2(String unicode) throws Exception {
        StringBuilder sb = new StringBuilder();
        String[] hex = unicode.split("\\\\u");
        if (hex.length < 2) return unicode;
        sb.append(hex[0]);
        for (int i = 1; i < hex.length; i++) {
            String hex1 = hex[i];
            String end = "";
            String number = "";
            if (hex1.length() > 4) {
                number = hex1.substring(4);
                hex1 = hex1.replaceAll(number, "");
            } else if (hex1.length() < 4) {
                sb.append(hex1);
                continue;
            }
            if (hex1.contains("<")) {
                end = hex1.substring(hex1.indexOf("<"));
                hex1 = hex1.replaceAll(end, "");
            }
            if (!"".equals(hex1)) {
                int index = Integer.parseInt(hex1, 16);
                sb.append((char) index).append(end);
            }
            sb.append(number);
        }
        return sb.toString();
    }

    /**
     * 判断是否为中文编码并转码
     *
     * @param str
     * @return
     */
    public static String cnorEn(String str) throws Exception {
        char[] chars = str.toCharArray();
        boolean isGo = false;
        for (char c : chars) {
            //中文字符
            if (c >= 0x0391 && c <= 0xFFE5) {
                isGo = true;
            }
           /* if(c>=0x0000 && c<=0x00FF){ //英文字符
                return 2;
            } */
        }
        if (isGo)
            return stringToUnicode(str);
        return str;
    }


    /**
     * 去除字符串后面的所有0
     *
     * @param str   字符串
     * @param index 最少匹配下标  也就是 返回字符串最少几位
     * @return
     */
    public static String removeStrEndZero(String str, int index) {
        if (str == null || "".equals(str)) return null;
        byte[] bytes = str.getBytes();
        int len = -1;
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            if (bytes[i] == 48) {
                if (len == -1) {
                    len = i;
                }
            } else {
                len = -1;
            }
        }
        if (len != -1) {
            if (len > index) {
                return new String(bytes, 0, len);
            } else {
                return new String(bytes, 0, index);
            }

        }
        return str;
    }

    /**
     * 解析字符串并返回list
     *
     * @param suffer 切割字符串
     * @param str    原字符串
     * @return
     */
    public static List<String> getListByStr(String suffer, String str) {
        if (suffer == null) {
            suffer = ",";
        }
        if (str == null || "".equals(str)) return null;
        List<String> list = new ArrayList<>();
        if (str.contains(suffer)) {
            if (str.endsWith(suffer)) {
                str = str.substring(0, str.length() - 1);
            }
            String[] split = str.split(suffer);
            Collections.addAll(list, split);
        } else {
            list.add(str);
        }
        if (list.isEmpty()) return null;
        return list;
    }

    public static String stringAppend(String... s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : s) {
            if (null != string && !"".equals(string)) {
                stringBuilder.append(string);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 格式化数字，将字符串类型的数字转化为整数格式的数字
     *
     * @param str 数据源
     * @return
     */
    public static String formatNbrToInteger(String str) {
        int idx = str.lastIndexOf(".");//查找小数点的位置
        String strNum = str.substring(0, idx);//截取从字符串开始到小数点位置的字符串，就是整数部分
        int num = Integer.valueOf(strNum);//把整数部分通过Integer.valueof方法转换为数字
        String result = num + "";
        return result;
    }

    /**
     * 格式化(4098接口)申请分期金额
     *
     * @param amount 数据源
     *               800，上送00000080000   11位
     */
    public static String formatApplyAmount(String amount) {
        int idx = amount.lastIndexOf(".");//查找小数点的位置
        String points = amount.substring(idx + 1, amount.length());//判断是几位小数
        String strNum = amount.substring(0, idx);//截取从字符串开始到小数点位置的字符串，就是整数部分
        int length = strNum.length();
        String pre = "";
        for (int i = 0; i < 9 - length; i++) {
            pre = pre + "0";
        }
        String result = "";
        if (points.length() == 1) {
            result = pre + strNum + amount.substring(idx + 1, amount.length()) + "0";
        } else {
            result = pre + strNum + amount.substring(idx + 1, amount.length());
        }
        return result;
    }

    /**
     * 身份证校验
     *
     * @param card 身份证号
     * @return
     */
    public static boolean isIdCard(String card) {
        if (card == null || "".equals(card)) {
            return false;
        }
        //定义 叛别用户 身份证号的正则表达式 （15位 或 18位，最后一位可以为字母）
        String requal = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|(10|20|30|31))\\d{3}[0-9Xx]$)|"
                + "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";

        //  假设18位 身份证号码：
        //   ^ 表示开头
        //  [1-9]         第一位1-9 中的一个     4    注意！！ 前六位代表地址，此处是 拆分 讲解 对正则 的注释
        //  \\d{5}        五位数字               10001（前六位省市县地区）
        //  (18|19|20)    19   （现阶段可能取值范围18xx-20xx年）
        //  \\d{2}        91   （年份）
        //  ((0[1-9])|(10|11|12))         01（月份）
        //  (([0-2][1-9])|10|20|30|31)    01（日期）    也可写成(([0-2][1-9])|(10|20|30|31))
        //  \\d{3}        三位数字        123（第十七位奇数表示男，偶数表示女）
        //  [0-9Xx]       0123456789Xx 其中的一个   X（第十八位为校验值）
        //  $结尾

        //  假设15位身份证号码： 410001910101123
        //  ^ 开头
        //  [1-9]          第一位1-9中的一个      4
        //  \\d{5}         五位数字               10001（前六位省市县地区）
        //  \\d{2}         91（年份）             表示 91年
        //  ((0[1-9])|(10|11|12))        01（月份）
        //  (([0-2][1-9])|10|20|30|31)   01（日期）
        //  \\d{3}         123（第十五位奇数代表男，偶数代表女），15位身份证不含X
        //  $结尾
        boolean matches = card.matches(requal);

        //判断 第 18位 校验值 ，校验算法涉及两次mod 11的过程
        // 二代身份证中的 号码第十八位的计算方法为：
        if (matches) {
            if (card.length() == 18) {
                try {
                    char[] charArray = card.toCharArray();
                    //1，将前面的身份证号码17位数分别乘以不同的系数，系数为此处的 加权因子
                    //前十七位加权因子
                    int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                    int sum = 0;
                    // 2，将这17位数字 和系数相乘 的结果相加
                    for (int i = 0; i < idCardWi.length; i++) {
                        int current = Integer.parseInt(String.valueOf(charArray[i]));
                        // 相乘对应的 加权因子系数
                        int count = current * idCardWi[i];
                        // 结果相加
                        sum += count;
                    }
                    char idCardLast = charArray[17];
                    // 3，结果和 除以11，查看余数
                    int idCardMod = sum % 11;
                    // 4，这是除以 11后，可能产生的 11位余数对应的验证码(--对应下标)，其中 X 代表罗马数字 10
                    String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                    if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                        return true;
                    } else {
                        /*System.out.println("身份证最后一位："+String.valueOf(idCardLast).toUpperCase()+
                                "错误，正确的应该是："+idCardY[idCardMod].toUpperCase());*/
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    //System.out.println("异常："+card);
                    return false;
                }
            }
        }
        return matches;
    }

    //根据身份证号获取性别 0-男  1-女
    //根据银联接口返回的分为单位的金额转换为元

    public static String getSexByIdNo(String idCardNo) {
        String sexCode = idCardNo.substring(idCardNo.length() - 2, idCardNo.length() - 1);
        if (Double.valueOf(sexCode) % 2 == 0) {
            return "女";
        } else {
            return "男";
        }
    }

    //根据身份证号获取性别 0-男  1-女
    //根据银联接口返回的分为单位的金额转换为元

    public static String getSexCodeByIdNo(String idCardNo) {
        String sexCode = idCardNo.substring(idCardNo.length() - 2, idCardNo.length() - 1);
        if (Double.valueOf(sexCode) % 2 == 0) {
            return "2";
        } else {
            return "1";
        }
    }
    /**
     * 获取交易流水号
     *
     * @return
     */
    public static String getFlowNo() {
        String orderNo;
        String trandNo = String.valueOf((int)(Math.random()*900)+100);
        String sdf = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        orderNo = sdf + trandNo;
        return orderNo;
    }



    /**
     * yyyy-MM-dd HH:mm:ss.SSS
     */
    private static final String DATETIME_FULL_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
    /**
     * 将文件中的内容按照行读取，将放入数据容器List中
     * @param filePath 文件路径
     * @return 包含每一行文件内容的List
     */
    public static List<String> readFileLineContext(Class<?> clazz, String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));// 绝对路径
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * 格式化打印文字到屏幕，带执行时间，换行
     * @param str
     * @param args
     */
    public static String printlnHaveTime(String str, Object... args) {
        str = getCurrDefaultFullDateTime() + ": " + str;
        println(str, args);
        return str;
    }
    /**
     * 格式化打印文字到屏幕，带执行时间，换行
     * @param str
     * @param args
     */
    public static void printHaveTime(String str, Object... args) {
        str = getCurrDefaultFullDateTime() + ": " + str;
        print(str, args);
    }
    /**
     * 格式化打印文字到屏幕，换行
     * @param str
     * @param args
     */
    public static void println(String str, Object... args) {
        print(str + "\r\n", args);
    }
    /**
     * 格式化打印文字到屏幕，不换行
     * @param str
     * @param args
     */
    public static void print(String str, Object... args) {
        System.out.format(str, args);
        // 控制打印速度
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * 格式化打印文字到屏幕，不换行
     * @param str
     * @param args
     */
    public static void printNoSleep(String str, Object... args) {
        System.out.format(str, args);
    }
    /**
     * 得到yyyy-MM-dd HH:mm:ss.SSS格式的服务器当前日期时间
     * @return yyyy-MM-dd HH:mm:ss.SSS
     */
    public static String getCurrDefaultFullDateTime() {
        return formatDate(new Date(), DATETIME_FULL_PATTERN);
    }
    /**
     * 将Date对像格式化成对应的日期字符串
     * @param date 要格式化的Date对像
     * @param pattern 日期格式
     * @return 目标格式的日期
     */
    public static String formatDate(Date date, String pattern) {
        if(date == null || StringUtils.isBlank(pattern)) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }
}

