package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.putong.Phone;
import com.example.demo.putong.TypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/17 10:55
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class EnumTest extends DemoApplicationTests{

    @Test
    public void enumListTest(){
        List<Map> list = TypeEnum.typeEnumList();
        List<Phone> phones = Lists.newArrayList();
       /* list.forEach(i->{
            log.info("获取的结果：{}",i.get("name"));
            Phone phone = new Phone();
            phone.setName(i.get("name").toString());
            phone.setColor("red");
            phones.add(phone);
        });*/

        for (Map s: list){
            log.info("获取的结果：{}",s.get("name"));
          Phone phone = new Phone();
          phone.setName(s.get("name").toString());
          phone.setColor("red");
          phones.add(phone);
        }
        log.info("赋值得到的结果：{}",phones.toString());
    }

    @Test
    public void cycleSetValueTest(){
        List<Phone> phoneList = Data.phoneList();
        List<Map> Enumlist = TypeEnum.typeEnumList();
        List<Phone> phones = Lists.newArrayList();
        phoneList.forEach(phone -> {
            Enumlist.forEach(i->{
                Phone vo = new Phone();
                vo.setName(phone.getName());
                vo.setPrice(phone.getPrice());
                vo.setColor(phone.getColor());
                vo.setBrand(i.get("name").toString());
                phones.add(vo);
            });
    });
        log.info("得到的数据：{}", JSON.toJSON(phones));
    }


}
