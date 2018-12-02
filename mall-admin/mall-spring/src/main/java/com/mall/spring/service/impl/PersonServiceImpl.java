package com.mall.spring.service.impl;

import com.mall.spring.bean.Person;
import com.mall.spring.bean.User;
import com.mall.spring.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 超
 * Create by fengc on  2018/12/2 20:12
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Resource(name = "person")
    private Person person;
    @Resource
    private User user;

    @Override
    public Person addPerson(Person person) {
        System.out.println("进入了PersonServiceImpl类的addPerson()...............");
        return person;
    }

    @Override
    public void delPerson(String code) {
        int i = 10;
        int count = i / 0 ;
        System.out.println("进入了PersonServiceImpl类的delPerson()...............");
    }
}
