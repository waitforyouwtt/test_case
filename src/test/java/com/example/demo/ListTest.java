package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.putong.Roles;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;
import static com.example.demo.Data.rolesList;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 13:51
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class ListTest extends DemoApplicationTests{

    @Test
    public void testA(){
        List<Roles> rolesList = rolesList();
        long count = rolesList.stream().distinct().count();
        boolean isRepeat = count < rolesList.size();
        System.out.println(count);//输出2

        List<Integer> integers = rolesList.stream().map(Roles::getId).collect(Collectors.toList());
        long idCount = integers.stream().distinct().count();
        boolean repeat = idCount < integers.size();
        System.out.println(idCount);
        if(repeat){
            System.out.println(true);//输出true 拥有重复值
        }else{
            System.out.println(false);//输出true  没有重复值
        }

        if(isRepeat){
            System.out.println(true);//输出true 拥有重复值
        }else{
            System.out.println(false);//输出true  没有重复值
        }

        Map<String, List<Roles>> map = rolesList.stream().collect(Collectors.groupingBy(o -> o.getRoleName().concat(String.valueOf(o.getId()))));

        map.forEach((k,v)->{
            if (v.size()>1){
                System.out.println("存在重复值："+k);
            }else{
                System.out.println("不存在重复值");
            }
        });
    }

    @Test
    public void fd(){
        OrderItem one = new OrderItem();
        one.setGoodsCode("1001");
        one.setGoodsName("娃哈哈");
        one.setQty(new BigDecimal(4));
        one.setFPaySubAmt(new BigDecimal(4));
        one.setPPaySubAmt(new BigDecimal(4));
        one.setPPaidSubAmt(new BigDecimal(4.5));

        OrderItem two = new OrderItem();
        two.setGoodsCode("1002");
        two.setGoodsName("洽洽瓜子");
        two.setQty(new BigDecimal(5));
        two.setFPaySubAmt(new BigDecimal(5));
        two.setPPaySubAmt(new BigDecimal(5));
        two.setPPaidSubAmt(new BigDecimal(5.5));

        List<OrderItem> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        log.info("得到的结果：{}",buildBuyGoodsDetail(list));

        String str = "娃哈哈^4|洽洽瓜子^5";
        int query = query(str);

        String s = totalQuantity(list);
        log.info("得到商品总数量：{}",s);

    }

    private String orderItems2GoodDetailsWrapper(List<OrderItem> orderItems) {
        if (CollectionUtils.isEmpty(orderItems)) {
            return StringUtils.EMPTY;
        }
        StringBuffer sb = new StringBuffer();
        for (OrderItem orderItem : orderItems) {
            if (StringUtils.isNotBlank(orderItem.getGoodsCode())
                    && StringUtils.isNotBlank(orderItem.getGoodsName())
                    && orderItem.getQty() != null
                    && orderItem.getPPaidSubAmt() != null) {
                //实际支付金额
                BigDecimal unitAmt = orderItem.getPPaySubAmt().add(orderItem.getFPaySubAmt());
                sb.append("|").append(orderItem.getGoodsCode())
                        .append(",").append(orderItem.getGoodsName())
                        .append(",").append(orderItem.getQty())
                        .append(",").append(unitAmt);
            }
        }
        return sb.length() > 0 ? sb.toString().substring(1) : "";
    }

    private String buildBuyGoodsDetail(List<OrderItem> orderItems){
        if (org.springframework.util.CollectionUtils.isEmpty(orderItems)) {
            return StringUtils.EMPTY;
        }
        StringBuffer sb = new StringBuffer();
        for (OrderItem orderItem : orderItems) {
            if (StringUtils.isNotBlank(orderItem.getGoodsCode())
                    && StringUtils.isNotBlank(orderItem.getGoodsName())
                    && orderItem.getQty() != null
                    && orderItem.getPPaidSubAmt() != null) {
                //实际支付金额
                BigDecimal unitAmt = orderItem.getPPaySubAmt().add(orderItem.getFPaySubAmt());
                sb.append("|").append(orderItem.getGoodsName()).append("^").append(orderItem.getQty());
            }
        }
        return sb.length() > 0 ? sb.toString().substring(1) : "";
    }

    private String totalQuantity(List<OrderItem> goodsInfoList){
        BigDecimal sum = goodsInfoList.stream().map(OrderItem::getQty).reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum.toString();
        //  return String.valueOf( goodsInfoList.stream().collect( Collectors.summarizingInt( OrderItem:: getQty) ).getSum() );
    }



    //娃哈哈^4|洽洽瓜子^5
    private int query(String str){
        List<String> stringList =Splitter.on("|").trimResults().splitToList(str);
        log.info("得到的数据：{}",stringList);
        return 0;
    }

    @Test
    public void jsonTest(){
        StringBuffer sb = new StringBuffer();
        sb.append("12").append("\"").append("xiaogege").append("\"");
        log.info("字符串前后拼接双引号：{}",sb);

        Map<String, String> map = new HashMap<>();
        map.put("name","luoxian");
        map.put("age","29");
        String jsonObject = JSON.toJSONString(map);
        log.info("map 转 json:{}",jsonObject);
    }

    @Test
    public void requestUrl() throws UnsupportedEncodingException {
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("name","luoxian");
        requestMap.put("age","29");

        StringBuffer urlSb = new StringBuffer("www.baidu.com");
        urlSb.append("?");
        for (String string : requestMap.keySet()) {
            urlSb.append(string).append("=").append(URLEncoder.encode(requestMap.get(string), "utf-8")).append("&");
        }

        String requestContent = urlSb.substring(0, urlSb.length() - 1);
        log.info(">>>>>>>>>>>>>>>>>>   请求报文 ： " + requestContent);


    }
}
