package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/11/8 10:06
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class CTest extends DemoApplicationTests {

    static int num = 0;

    @Test
    public void test1(){
        String pathName = "C://E://photo/self.jpg";
        String fileName = pathName.substring(0,pathName.lastIndexOf("."));
        log.info("获取到的文件名字结果：{}",fileName);
    }


}
