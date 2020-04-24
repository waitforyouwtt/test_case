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


    @Test
    public void test(){
        Object o = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<alipay>\n" +
                "\n" +
                "<is_success>F</is_success>\n" +
                "<error>PURCHASE_TRADE_NOT_EXIST</error>\n" +
                "\n" +
                "<sign>QZRPvccyWUzKF+fz6K7tQJdDzfe84kxwuY/InI9g6/Lb9Uh9ltDGfkCVAhYMSLxOHcvdBY691S6CzwfBAiTHP36xu3m3H667f5PDacJ+uzPBCKjsRO4KBVU3zgxA0BNzD2ITRykdck3pFoaMz1ELhFbMMzYGngwq0vxosEFsV+6hh64pnxtzcbgWGod4mq76zN5kcsue7dAOF3d5JGrvqdAYTwIw+n8xTXQuHtEydxNiy9acm9i3we6USauJ7tFOyFWrofvc7up0NvaR+cdsh/0NstcA+3ZoYCu+mDozaSHUP2N4QUq1KSXJvdUDPlWRuzgudSFDC5pe1jFXiLQWGQ==</sign>\n" +
                "\n" +
                "<sign_type>RSA2</sign_type>\n" +
                "\n" +
                "</alipay>\n";
        String isSuccess = getXMLValue(o,"is_success");
        log.info("is_success:{}",isSuccess);
    }

    /**
     * 解析xml
     * @param xml
     * @param key
     * @return
     */
    public static String getXMLValue(Object xml, String key){
        String value = "";
        if (xml != null) {
            String data = xml.toString();
            if (data.contains(key)) {
                String keyStart = new StringBuffer("<").append(key).append(">").toString();
                String keyEnd = new StringBuffer("</").append(key).append(">").toString();
                value = data.substring(data.indexOf(keyStart), data.indexOf(keyEnd)).replace(keyStart, "");
                log.info("读取支付宝返回的参数value:"+value);
            }
        }
        return value;
    }
}
