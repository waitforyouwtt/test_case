package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

/**
 * @Author: luoxian
 * @Date: 2020/5/20 15:01
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class StringTest extends DemoApplicationTests {

    @Test
    public void splitTest(){
        String music =  "李玉刚-更好遇见你";
        String singer = music.substring(0,music.indexOf("-"));
        log.info("得到的值：{}",singer);
    }
}
