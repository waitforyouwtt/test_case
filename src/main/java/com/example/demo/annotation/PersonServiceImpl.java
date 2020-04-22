package com.example.demo.annotation;

import com.alibaba.fastjson.JSON;
import com.example.demo.putong.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/3/26 17:45
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Override
    @PersonAnnotation
    public int savePerson(PersonVO person) {
        log.info("添加用户请求参数：{}", JSON.toJSONString(person));
        return 1;
    }

    @Override
    @PersonAnnotation
    public int updatePerson(PersonVO person) {
        log.info("修改用户请求参数：{}",JSON.toJSONString(person));
        return 1;
    }


}
