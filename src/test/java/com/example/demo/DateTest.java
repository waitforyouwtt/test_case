package com.example.demo;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/11 13:54
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class DateTest extends DemoApplicationTests{

    public static String DATE_TO_STRING_DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Test
    public void testDate(){
        String date = "20191212";
        String time = "125959";
        String dateTmp = date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8);
        String timeTmp = time.substring(0,2)+":"+time.substring(2,4)+":"+time.substring(4,6);
        String dateTimeTmp = dateTmp+" "+timeTmp;
        log.info("当前时间{}",getDate(dateTimeTmp,"yyyy-MM-dd HH:mm:ss"));
        log.info("当前时间{}",strToDateLong(dateTimeTmp));
    }

    public static String getDateFormat(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return  df.format(date);
    }

    public static Date getDate(String dateString, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (Exception e) {
            log.error("getDate error: dateString{}, format{}", dateString, format, e);
        }
        return date;
    }

    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_TO_STRING_DEFAULT_PATTERN);
        return formatter.parse(strDate, new ParsePosition(0));
    }

    @Test
    public void dateTest(){
        Date beginDate = strToDateLong("2012-12-12 12:12:12");
        Date endDate   = strToDateLong("2032-12-12 12:12:12");
        if (new Date().after(beginDate) || new Date().before(endDate)){
            log.info("跳出循环");
        }else{
            log.info("符合条件");
        }
    }

    @Test
    public void dateFormat(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd");
        String dateString = formatter.format(currentTime);
        log.info("dateS：{}",dateString);
    }

    @Test
    public void fd14(){
        log.info(getNowFormat());
        LocalDate today = LocalDate.now();
        //本月的第一天
        LocalDate firstday = LocalDate.of(today.getYear(),today.getMonth(),1);
        //本月的最后一天
        LocalDate lastDay =today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("本月的第一天" + firstday);
        System.out.println("本月的最后一天" + lastDay);

        log.info(getLastDay().substring(0,6));
    }

    public static String getNowFormat() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return  df.format(new Date());
    }

    private static String getLastDay(){
        return   LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).toString().replace("-", "");
    }

}
