package com.mall.demo.designpatterns.proxy;

/**
 * @author 超
 * Create by fengc on  2018/11/1 23:18
 */
public class Student implements Person {

    String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println( name +  "上缴了班费........50元.................");
    }
}
