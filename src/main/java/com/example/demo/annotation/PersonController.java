package com.example.demo.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/3/26 17:59
 * @Email: 15290810931@163.com
 */
@Controller
@Slf4j
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/save")
    public ModelAndView save(){
        PersonVO person = new PersonVO();
        person.setId(1);
        person.setUserName("张杰");
        person.setGender(1);

        int i = personService.savePerson(person);
        log.info("得到的结果：{}",i);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        return mv;
    }
}
