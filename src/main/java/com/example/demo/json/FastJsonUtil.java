package com.example.demo.json;

import com.alibaba.fastjson.JSON;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/6 14:15
 * @Email: 15290810931@163.com
 */
public class FastJsonUtil {

    public static String bean2Json(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        return JSON.parseObject(jsonStr, objClass);
    }
}
