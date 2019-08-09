package com.example.demo;

import com.example.demo.sms.SingleSms;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/11 13:54
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class SmsTest extends DemoApplicationTests{

    @Test
    public void sendSmsTest() throws IOException {
        SingleSms sms = Data.smsData();
        System.out.println("字符串长度："+sms.toString().length());
        System.out.println("压缩后：："+GZIPUtils.compress(sms.toString()).length);
        System.out.println("解压后："+GZIPUtils.uncompress(GZIPUtils.compress(sms.toString())).length);
        System.out.println("解压字符串后：："+GZIPUtils.uncompressToString(GZIPUtils.compress(sms.toString())).length());
    }
}
