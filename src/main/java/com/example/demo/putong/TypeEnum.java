package com.example.demo.putong;

import org.assertj.core.util.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/17 10:50
 * @Email: 15290810931@163.com
 */
public enum TypeEnum {
    VIVO("VIVO", "VIVO"),
    OPPO("OPPO", "OPPO"),
    All("ALL","全部")

    ;

    //声明一个构造方法
    TypeEnum(String name, String code){
        this.name=name;
        this.code=code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String name;
    private String code;

    //将枚举转换成list格式，这样前台遍历的时候比较容易，列如 下拉框 后台调用toList方法，便可以得到code 和name
    public static List<Map> toList() {
        //Lists.newArrayList() = new ArrayList() javac通过自动推导尖括号里的数据类型.
        List list = Lists.newArrayList();
        for (TypeEnum airlineTypeEnum : TypeEnum.values()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", airlineTypeEnum.getCode());
            map.put("name", airlineTypeEnum.getName());
            list.add(map);
        }
        return list;
    }

    public static List toList2(){
        List list = Lists.newArrayList();
        for (TypeEnum airlineTypeEnum : TypeEnum.values()) {
            list.add(airlineTypeEnum.getCode());
        }
        return list;
    }

}
