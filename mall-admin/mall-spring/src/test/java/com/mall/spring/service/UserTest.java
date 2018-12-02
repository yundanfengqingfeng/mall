package com.mall.spring.service;

import com.mall.spring.bean.Person;
import com.mall.spring.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author 超
 * Create by fengc on  2018/12/2 14:28
 */
public class UserTest {
    /**
     * 测试通过Spring的容器获取bean
     */
    //获取Spring的容器
    ApplicationContext applicationContext = null;
    @Before
    public void getApplicationContextInstance() {
        applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    }
    @Test
    public void test() {
        //获得bean .不是传统的需要new 出来，只需要通过Spring容器中取
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.addUser();
        System.out.println("------------------------------------------------------------------");
        userService.updateUser("name");
    }

    //@Test
    public void testBean() {
        User user = (User) applicationContext.getBean("user");
        System.out.println("user = " + user);
        User userOther = (User) applicationContext.getBean("userOther");
        System.out.println("userOther = " + userOther);
        Person person = (Person) applicationContext.getBean("person");
        System.out.println("person = " + person);
        System.out.println("person 中的数组 = " + Arrays.toString(person.getArrData()));
        System.out.println("person 中的数组 = " + Arrays.toString(person.getArrData()));
        System.out.println("person 中的List数组 = " + person.getList());
        System.out.println("person 中的Map = " + person.getMap());
    }

}
