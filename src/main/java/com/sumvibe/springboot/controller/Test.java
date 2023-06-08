package com.sumvibe.springboot.controller;

import com.sumvibe.springboot.utils.DateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        System.out.println(getYesDay1());
        System.out.println(getYesDay());
    }

   static String getYesDay() {
        LocalDate now = LocalDate.now().plusDays(-1);
        return now.toString()+" 00:00:00";
    }

   static String getYesDay1() {
        LocalDateTime now = LocalDateTime.now();
        now = now.minus(1, ChronoUnit.DAYS);
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        Date time = Date.from(zonedDateTime.toInstant());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date zero = calendar.getTime();
        return DateUtils.formatDate(zero);
    }

}
