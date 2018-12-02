package com.mall.spring.service;

import com.mall.spring.bean.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 超
 * Create by fengc on  2018/12/2 23:06
 */
public class PersonTest {

    //获取Spring的容器
    ApplicationContext applicationContext = null;

    @Before
    public void getApplicationContextInstance() {
        applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    }

    @Test
    public void test() {
        PersonService personService = (PersonService) applicationContext.getBean("personService");
        personService.addPerson(new Person());
        System.out.println("---------------------------------------------------------------------------");
        personService.delPerson("21321");
    }
}
