package com.example.demo;

import com.example.demo.label.ResActivityMessageVO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/19 9:54
 * @Email: 15290810931@163.com
 */
public class lineData {

    public static List<ResActivityMessageVO> buildResActivityMessageVO(){
        List<ResActivityMessageVO> messageVOList = new ArrayList<>();
        ResActivityMessageVO vo1 = new ResActivityMessageVO();
        vo1.setShopCode(9010);
        vo1.setPromotionType(1);
        vo1.setDiscountPrice(800);
        vo1.setPromotionCode("2200000668");
        vo1.setProductCode("3");
        vo1.setOldSellingPrice(1118);
        vo1.setChannelCode(22);
        vo1.setActivityName("凤凰小哥哥[直降]");
        vo1.setActivityBeginTime(DateTest.strToDateLong("2019-08-17 14:37:31"));
        vo1.setActivityEndTime(DateTest.strToDateLong("2019-08-17 14:37:31"));
        vo1.setChannelResource(1);

        ResActivityMessageVO omp = new ResActivityMessageVO();
        omp.setShopCode(9010);
        omp.setPromotionType(1);
        omp.setDiscountPrice(800);
        omp.setPromotionCode("2200000668");
        omp.setProductCode("3");
        omp.setOldSellingPrice(1118);
        omp.setChannelCode(22);
        omp.setActivityName("凤凰小哥哥[omp]");
        omp.setActivityBeginTime(DateTest.strToDateLong("2019-08-18 14:37:31"));
        omp.setActivityEndTime(DateTest.strToDateLong("2019-08-18 14:37:31"));
        omp.setChannelResource(2);

        ResActivityMessageVO vo2 = new ResActivityMessageVO();
        vo2.setShopCode(9010);
        vo2.setPromotionType(3);
        vo2.setPromotionCode("2200000669");
        vo2.setActivityBeginTime(DateTest.strToDateLong("2019-08-16 14:42:05"));
        vo2.setActivityEndTime(DateTest.strToDateLong("2019-08-16 14:42:05"));
        vo2.setProductCode("3");
        vo2.setSubtractPrice(new BigDecimal(1000));
        vo2.setBuyPiece(100);
        vo2.setRuleType(32);
        vo2.setOldSellingPrice(1118);
        vo2.setChannelCode(22);
        vo2.setActivityName("凤凰小哥哥[满件]");
        vo2.setChannelResource(1);


        ResActivityMessageVO vo3 = new ResActivityMessageVO();
        vo3.setShopCode(9010);
        vo3.setPromotionType(3);
        vo3.setPromotionCode("2200000669");
        vo3.setActivityBeginTime(DateTest.strToDateLong("2019-08-16 14:42:05"));
        vo3.setActivityEndTime(DateTest.strToDateLong("2019-08-16 14:42:05"));
        vo3.setProductCode("3");
        vo3.setSubtractPrice(new BigDecimal(1200));
        vo3.setBuyPiece(180);
        vo3.setRuleType(32);
        vo3.setOldSellingPrice(1118);
        vo3.setChannelCode(22);
        vo3.setActivityName("凤凰小哥哥[满件]");
        vo3.setChannelResource(1);

        ResActivityMessageVO vo4 = new ResActivityMessageVO();
        vo4.setBuyPrice(new BigDecimal(10000));
        vo4.setShopCode(9080);
        vo4.setPromotionType(2);
        vo4.setActivityBeginTime(DateTest.strToDateLong("2019-08-16 15:07:43"));
        vo4.setActivityEndTime(DateTest.strToDateLong("2019-08-16 15:07:43"));
        vo4.setPromotionCode("2200000670");
        vo4.setProductCode("1042948");
        vo4.setSubtractPrice(new BigDecimal(1000));
        vo4.setRuleType(21);
        vo4.setOldSellingPrice(999900);
        vo4.setChannelCode(22);
        vo4.setActivityName("凤凰小哥哥[满减]");
        vo4.setChannelResource(1);

        ResActivityMessageVO vo5 = new ResActivityMessageVO();
        vo5.setShopCode(9010);
        vo5.setPromotionType(1);
        vo5.setActivityBeginTime(DateTest.strToDateLong("2019-08-16 15:43:51"));
        vo5.setActivityEndTime(DateTest.strToDateLong("2019-08-16 15:43:51"));
        vo5.setDiscountPrice(800);
        vo5.setPromotionCode("2200000671");
        vo5.setProductCode("3");
        vo5.setOldSellingPrice(1118);
        vo5.setChannelCode(22);
        vo5.setActivityName("凤凰小哥哥[直降2]");
        vo5.setChannelResource(1);

        ResActivityMessageVO vo6 = new ResActivityMessageVO();
        vo6.setShopCode(9010);
        vo6.setPromotionType(1);
        vo6.setDiscountPrice(800);
        vo6.setPromotionCode("2200000672");
        vo6.setProductCode("3");
        vo6.setOldSellingPrice(1118);
        vo6.setChannelCode(22);
        vo6.setActivityName("凤凰小哥哥[直降2]");
        vo6.setActivityBeginTime(DateTest.strToDateLong("2019-08-16 15:45:07"));
        vo6.setActivityEndTime(DateTest.strToDateLong("2019-08-16 15:45:07"));
        vo6.setChannelResource(1);

        messageVOList.add(vo1);
      //  messageVOList.add(omp);
        messageVOList.add(vo2);
        messageVOList.add(vo3);
        messageVOList.add(vo4);
        messageVOList.add(vo5);
        messageVOList.add(vo6);
        return messageVOList;
    }
}
