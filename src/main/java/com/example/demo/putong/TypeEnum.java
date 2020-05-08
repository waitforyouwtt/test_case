package com.example.demo.putong;


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


}
