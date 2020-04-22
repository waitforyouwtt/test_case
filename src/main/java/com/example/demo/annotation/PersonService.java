package com.example.demo.annotation;

import com.example.demo.putong.Person;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/3/26 17:45
 * @Email: 15290810931@163.com
 */
public interface PersonService {

    int savePerson(PersonVO person);

    int updatePerson(PersonVO person);
}
