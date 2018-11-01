package com.mall.demo.designpatterns.proxy.statics;

import com.mall.demo.designpatterns.proxy.Person;
import com.mall.demo.designpatterns.proxy.Student;

/**
 * @author 超
 * Create by fengc on  2018/11/1 23:19
 */
public class StudentProxy implements Person {

   Student student;

    public StudentProxy(Person stu) {

        if (stu.getClass() == Student.class) {
            student = (Student) stu;
        }
    }

    @Override
    public void giveMoney() {
        System.out.println("静态代理了此方法....................");
        student.giveMoney();
    }
}
