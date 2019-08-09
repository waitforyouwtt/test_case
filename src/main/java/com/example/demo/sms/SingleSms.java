package com.example.demo.sms;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/11 13:42
 * @Email: 15290810931@163.com
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SingleSms {

    //用户appId
    @NotNull
    private String appId;
    //是否启用GZIP 压缩 [on 是 off 否]
    private String gzip;
    //字符集 [默认UTF-8]
    private String encode;
    //手机号
    @NotNull
    private String mobile;
    //短信内容
    @NotNull
    private String content;
    //定时发送时间[yyyy-MM-dd HH:mm:ss]
    //定时时间在 90 天之内 ,不填为及时发送
    private String timerTime;
    //自定义消息ID
    private String customSmsId;
    //扩展码[最长12位]
    private String extendedCode;
    //请求时间
    @NotNull
    private Long requestTime;
    //请求有效时间
    @NotNull
    private Integer requestValidPeriod;
}
