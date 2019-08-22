package com.example.demo.label;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/19 9:52
 * @Email: 15290810931@163.com
 */
@Data
public class ResActivityLabel {

    private String promotionCode;
    private Integer channelCode;
    private String promotionType;
    private String activityLabel;
    private String activityName;

    private Date activityBeginTime;
    private Date activityEndTime;
}
