package com.example.demo.label;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/19 9:48
 * @Email: 15290810931@163.com
 */
@Data
public class ResActivityMessageVO {


    private String promotionCode;
    private String productCode;
    private Integer promotionType;
    private Integer channelCode;
    private Integer shopCode;
    private Integer oldSellingPrice;
    private Integer discountPrice;
    private BigDecimal buyPrice;
    private Integer buyPiece;
    private BigDecimal discount;
    private BigDecimal subtractPrice;
    private Integer discountsCount;
    private Integer ruleType;
    private String activityName;
    //1 中台 2 omp
    private Integer channelResource;

    private Date activityBeginTime;
    private Date activityEndTime;
}
