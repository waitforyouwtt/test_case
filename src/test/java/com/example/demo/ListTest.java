package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 13:51
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class ListTest extends DemoApplicationTests{


    @Test
    public void jsonTest(){
        StringBuffer sb = new StringBuffer();
        sb.append("12").append("\"").append("xiaogege").append("\"");
        log.info("字符串前后拼接双引号：{}",sb);

        Map<String, String> map = new HashMap<>();
        map.put("name","luoxian");
        map.put("age","29");
        String jsonObject = JSON.toJSONString(map);
        log.info("map 转 json:{}",jsonObject);
    }

    @Test
    public void requestUrl() throws UnsupportedEncodingException {
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("name","luoxian");
        requestMap.put("age","29");

        StringBuffer urlSb = new StringBuffer("www.baidu.com");
        urlSb.append("?");
        for (String string : requestMap.keySet()) {
            urlSb.append(string).append("=").append(URLEncoder.encode(requestMap.get(string), "utf-8")).append("&");
        }

        String requestContent = urlSb.substring(0, urlSb.length() - 1);
        log.info(">>>>>>>>>>>>>>>>>>   请求报文 ： " + requestContent);


    }
}
