package com.example.demo;

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
        List<Map> list = TypeEnum.toList();
        List<Phone> phones = Lists.newArrayList();
        list.forEach(i->{
            log.info("获取的结果：{}",i.get("name"));
            Phone phone = new Phone();
            phone.setName(i.get("name").toString());
            phone.setColor("red");
            phones.add(phone);
        });
        log.info("赋值得到的结果：{}",phones.toString());

       /* for (Map s: list){
            log.info("获取的结果：{}",s.get("name"));
          Phone phone = new Phone();
          phone.setName(s.get("name").toString());
          phone.setColor("red");
          phones.add(phone);
        }
        log.info("赋值得到的结果：{}",phones.toString());*/
    }

    @Test
    public void change(){
        List<Phone> phoneList = Data.phoneList();
        List<Map> Enumlist = TypeEnum.toList();
        List<Phone> phones = Lists.newArrayList();
        for (Phone p: phoneList){
            Enumlist.forEach(i->{
                log.info("获取的结果name：{}",i.get("name"));
                Phone phone = new Phone();
                phone.setName(p.getName());
                phone.setPrice(p.getPrice());
                phone.setColor(p.getColor());
                phone.setBrand(i.get("name").toString());
                phones.add(phone);
            });
        }
        log.info("得到的数据：{}",phones);
    }

    @Test
    public void getList(){
        List list = TypeEnum.toList2();

        String str = "时光如水，不舍昼夜。\n" +
                "转瞬便已来到法本3月有余，这段时光里我抱着虚心学习的态度，认真遵守公司的只读，熟悉公司的企业文化，了解公司的系统开发框架、主要技术。主动和同事沟通、学习经验。在接到项目开发任务后，努力和认真的工作，并在同事的帮忙下，如期完成了项目的开发。\n" +
                "熟悉促销的业务需求，主要任务是参与促销的需求的分析与讨论，整理出系统的流程和基本功能模块，并设计出数据库。完成促销接口系统功能的开发和测试，主要任务是开发web页面的接口编码。\n" +
                "\n" +
                "在这期间，我也发现自我的很多不足，主要表此刻对公司的一些业务不够了解，关于这点我以后要加强和同事的沟通和学习，还有就是代码的组织不是很清晰，关于这点，在此刻的开发中我已经改善。";
        log.info("获取数据：{}",str.length());
    }


}
