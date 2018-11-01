package com.mall.demo.designpatterns.proxy.dynamic;

import com.mall.demo.designpatterns.proxy.Person;
import com.mall.demo.designpatterns.proxy.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author 超
 * Create by fengc on  2018/11/1 23:32
 * 使用动态代理
 */
public class ProxyTest {

    public static void main(String[] args) {

        Person stu = new Student("张三");
        InvocationHandler stuHandler = new StuInvocationHandler<Person>(stu);
        Person stuProxy = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(),new Class<?>[]{Person.class},stuHandler);
        stuProxy.giveMoney();
    }

}
