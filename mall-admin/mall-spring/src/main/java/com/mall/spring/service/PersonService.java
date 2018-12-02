package com.mall.spring.service;

import com.mall.spring.bean.Person;

/**
 * @author 超
 * Create by fengc on  2018/12/2 20:11
 */

public interface PersonService {

    Person addPerson(Person person);

    void delPerson(String code);
}
