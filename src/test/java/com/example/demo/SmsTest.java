package com.example.demo;

import com.example.demo.putong.One;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/11 13:54
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class SmsTest extends DemoApplicationTests{

    @Test
    public void getNow(){
        /*DateTime dateTime = new DateTime();*/
        //System.out.println("得到的结果："+getMilliSecondToTomorrow() / 1000 / 60);
        String testUrl = null;
        String url = Optional.ofNullable(testUrl).orElse("http:www.jd.com");
        log.info("最终的结果：{}",url);

    }

    public static Long getMilliSecondToTomorrow() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date = cal.getTime();
        return date.getTime() - System.currentTimeMillis();
    }
}
