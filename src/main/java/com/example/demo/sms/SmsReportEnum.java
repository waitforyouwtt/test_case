package com.example.demo.sms;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/11 16:22
 * @Email: 15290810931@163.com
 */
public enum SmsReportEnum {

    DELIVRD("DELIVRD","成功"),
    TIMEOUT("TIMEOUT","运营商状态报告超时"),
    FAIL_BALANCE("FAIL_BALANCE","余额不足"),
    FAIL_MOBILE("FAIL_MOBILE","手机号错误"),
    FAIL_MOBILE_SUPPORT("FAIL_MOBILE_SUPPORT","手机号不支持"),
    FAIL_MOBILE_REPEAT("FAIL_MOBILE_REPEAT","手机号重复"),
    FAIL_AUDITING_REFUSED("FAIL_AUDITING_REFUSED","审核拒绝"),
    FAIL_BLACK_LIST("FAIL_BLACK_LIST","黑名单失败"),
    FAIL_BLACK_DICT("FAIL_BLACK_DICT","黑字典失败"),
    FAIL_UNSUBSCRIBE("FAIL_UNSUBSCRIBE","用户退订"),
    FAIL_WHITE_LIST("FAIL_WHITE_LIST","白名单失败"),
    FAIL_INTERCEPT("FAIL_INTERCEPT","拦截失败"),
    FAIL_SIGN("FAIL_SIGN","签名错误"),
    FAIL_SEND_FILTER("FAIL_SEND_FILTER","发送频率过快"),
    FAIL_RESPONSE ("FAIL_RESPONSE","运营商响应失败"),
    FAIL_UNKNOW("FAIL_UNKNOW","未知失败");

    private String code;
    private String msg;

    SmsReportEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
