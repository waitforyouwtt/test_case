package com.example.demo;

import com.example.demo.annotation.PersonService;
import com.example.demo.annotation.PersonVO;
import com.example.demo.putong.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/3/26 17:48
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class PersonAnnotation extends DemoApplicationTests {

    @Autowired
    PersonService personService;

    @Test
    public void AnnotationTest(){
        PersonVO person = new PersonVO();
        person.setId(1);
        person.setUserName("张杰");
        person.setGender(1);

        int i = personService.savePerson(person);
        log.info("得到的结果：{}",i);
    }
}
