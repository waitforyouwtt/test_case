package com.example.demo.putong;

import lombok.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/6 14:31
 * @Email: 15290810931@163.com
 */
@Data
public class Person {
    private String name;
    private FullName fullName;
    private int age;
    private Date birthday;
    private List<String> hobbies;
    private Map<String, String> clothes;
    private List<Person> friends;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Person [name=" + name + ", fullName=" + fullName + ", age="
                + age + ", birthday=" + birthday + ", hobbies=" + hobbies
                + ", clothes=" + clothes + "]\n");
        if (friends != null) {
            str.append("Friends:\n");
            for (Person f : friends) {
                str.append("\t").append(f);
            }
        }
        return str.toString();
    }
}
