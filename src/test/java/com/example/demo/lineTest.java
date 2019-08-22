package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.label.ResActivityLabel;
import com.example.demo.label.ResActivityLabelVO;
import com.example.demo.label.ResActivityMessageVO;
import com.example.demo.putong.Roles;
import com.example.demo.putong.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 13:51
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class lineTest extends DemoApplicationTests{

    @Test
    public void testBOK() {
        List<ResActivityMessageVO> messageVOList = lineData.buildResActivityMessageVO();
        Map<String, List<ResActivityMessageVO>> activityMap = messageVOList.stream().collect(Collectors.groupingBy(ResActivityMessageVO::getProductCode));
        log.info("得到的数据Map：{}", JSON.toJSON(activityMap));
        //要返回的标签数据
        List<ResActivityLabelVO> activityLabels = Lists.newArrayList();
        activityMap.forEach((k, v) -> {
            ResActivityLabelVO activityLabelVO = new ResActivityLabelVO();
            List<ResActivityLabel> activityLabelList = new ArrayList<>();
          /*  v.stream().forEach((ResActivityMessageVO messageVO) -> {*/
          for(ResActivityMessageVO messageVO : v){
              if (new Date().before(messageVO.getActivityBeginTime()) || new Date().after(messageVO.getActivityEndTime())){
                  continue;
              }
              //直降
              if (messageVO.getPromotionType() == 1) {
                  ResActivityLabel vo = new ResActivityLabel();
                  vo.setPromotionType("直降");
                  //计算打几折：
                  //折扣金额
                  List<ResActivityMessageVO> collectCenter = v.stream().filter(aMessageVO -> aMessageVO.getPromotionType() == 1 && aMessageVO.getChannelResource() == 1).collect(Collectors.toList());
                  List<ResActivityMessageVO> collectOmp = v.stream().filter(aMessageVO -> aMessageVO.getPromotionType() == 1 && aMessageVO.getChannelResource() == 2).collect(Collectors.toList());
                  //如果中台 ，融通都有，则取中台最大的
                  ResActivityMessageVO collect = null;
                  if (collectCenter != null && collectOmp != null) {
                      collect = v.stream().filter(aMessageVO -> aMessageVO.getChannelResource() == 1).collect(Collectors.maxBy(Comparator.comparing (ResActivityMessageVO::getActivityBeginTime))).get();
                  } else if (collectCenter == null) {
                      collect = v.stream().filter(aMessageVO -> aMessageVO.getChannelResource() == 2).collect(Collectors.maxBy(Comparator.comparing(ResActivityMessageVO::getActivityBeginTime))).get();
                  }
                  log.info("直降得到时间最大的：{}", collect);
                  BigDecimal discountRate = new BigDecimal(collect.getDiscountPrice()).multiply(new BigDecimal(10)).divide(new BigDecimal(collect.getOldSellingPrice()), 1, BigDecimal.ROUND_DOWN);
                  vo.setActivityLabel(discountRate + "折");
                  vo.setChannelCode(collect.getChannelCode());
                  vo.setActivityBeginTime(collect.getActivityBeginTime());
                  vo.setActivityEndTime(collect.getActivityEndTime());
                  vo.setActivityName(collect.getActivityName());
                  activityLabelList.add(vo);
              }
              //满减：阶梯满减 | 每满减
              if (messageVO.getPromotionType() == 2) {
                  ResActivityLabel vo = new ResActivityLabel();
                  vo.setPromotionType("满减");
                  if (messageVO.getRuleType() != null) {
                      ResActivityMessageVO collect = v.stream().filter(aMessageVO -> aMessageVO.getPromotionType() == 2).collect(Collectors.maxBy(Comparator.comparing(ResActivityMessageVO::getBuyPrice))).get();
                      if (messageVO.getRuleType() == 21) {
                          vo.setActivityLabel("满" + collect.getBuyPrice() + "减" + collect.getSubtractPrice() + "元");
                      } else if (messageVO.getRuleType() == 22) {
                          vo.setActivityLabel("每满" + collect.getBuyPrice() + "减" + collect.getSubtractPrice() + "元");
                      }
                  }
                  vo.setActivityBeginTime(messageVO.getActivityBeginTime());
                  vo.setActivityEndTime(messageVO.getActivityEndTime());
                  vo.setChannelCode(messageVO.getChannelCode());
                  activityLabelList.add(vo);
              }
              //满件减 | 满件折
              else if (messageVO.getPromotionType() == 3) {
                  ResActivityLabel vo = new ResActivityLabel();
                  vo.setPromotionType("满件减元|满件打折");
                  ResActivityMessageVO collect = v.stream().filter(aMessageVO -> aMessageVO.getPromotionType() == 3).collect(Collectors.maxBy(Comparator.comparing (ResActivityMessageVO::getBuyPiece))).get();
                  if (messageVO.getRuleType() == 32) {
                      vo.setActivityLabel("满" + collect.getBuyPiece() + "件减" + collect.getSubtractPrice() + "元");
                  } else if (messageVO.getRuleType() == 31) {
                      vo.setActivityLabel("满" + collect.getBuyPiece() + "件" + collect.getDiscount() + "折");
                  }
                  vo.setChannelCode(messageVO.getChannelCode());
                  vo.setActivityBeginTime(messageVO.getActivityBeginTime());
                  vo.setActivityEndTime(messageVO.getActivityEndTime());
                  activityLabelList.add(vo);
              }

              activityLabelVO.setProductCode(messageVO.getProductCode());
              activityLabelVO.setActivityLabelList(activityLabelList.stream

                      ().distinct().collect(Collectors.toList()));
              return;
          }


            /*});*/
            activityLabels.add(activityLabelVO);
        });
        log.info("最终返回的结果JSON：{}", JSON.toJSON(activityLabels));
    }




}
