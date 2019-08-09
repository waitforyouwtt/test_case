package com.example.demo.sms;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/11 16:09
 * @Email: 15290810931@163.com
 */
public enum SmsStateEnum {
    SUCCESS("SUCCESS","成功"),
    ERROR_APPID("ERROR_APPID","AppId错误"),
    ERROR_NO_VOICE_SERVICE("ERROR_NO_VOICE_SERVICE","语音服务未开启"),
    ERROR_ENCRYPTION("ERROR_ENCRYPTION","解密失败[安全接口专用]"),
    ERROR_PARAMS("ERROR_PARAMS","请求参数错误"),
    ERROR_REQUEST_NO_VALID("ERROR_REQUEST_NO_VALID","请求超时"),
    ERROR_CLIENT_IP("ERROR_CLIENT_IP","未识别的IP"),
    ERROR_OVER_SPEED("ERROR_OVER_SPEED","请求超速"),
    ERROR_MOBILE_EMPTY("ERROR_MOBILE_EMPTY","手机号为空"),
    ERROR_MOBILE_NUMBER("ERROR_MOBILE_NUMBER","号码数量过多"),
    ERROR_MOBILE_ERROR("ERROR_MOBILE_ERROR","手机号错误"),
    ERROR_CONTENT_EMPTY("ERROR_CONTENT_EMPTY","短信内容为空"),
    ERROR_SMS_TIME("ERROR_SMS_TIME","定时时间过早或过久"),
    ERROR_CUSTOM_SMSID("ERROR_CUSTOM_SMSID","自定义消息ID过长"),
    ERROR_EXTENDED_CODE("ERROR_EXTENDED_CODE","扩展码错误"),
    ERROR_LONG_CONTENT ("ERROR_LONG_CONTENT","短信内容过长"),
    ERROR_VOICE_CONTENT("ERROR_VOICE_CONTENT","语音验证码格式错误"),
    ERROR_BALANCE("ERROR_BALANCE","余额不足"),
    ERROR_TIMESTAMP("ERROR_TIMESTAMP","时间戳错误"),
    ERROR_SIGN("ERROR_SIGN","签名错误");

    private String code;
    private String msg;

    SmsStateEnum(String code, String msg) {
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
