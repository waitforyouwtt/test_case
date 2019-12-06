package com.example.demo.json;

import net.sf.json.JSONObject;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/6 14:27
 * @Email: 15290810931@163.com
 */
public class JsonLibUtil {

    public static String bean2Json(Object obj) {
        JSONObject jsonObject = JSONObject.fromObject(obj);
        return jsonObject.toString();
    }

    @SuppressWarnings("unchecked")
    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        return (T) JSONObject.toBean(JSONObject.fromObject(jsonStr), objClass);
    }
}
