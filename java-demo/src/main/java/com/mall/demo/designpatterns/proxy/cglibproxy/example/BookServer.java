package com.mall.demo.designpatterns.proxy.cglibproxy.example;

/**
 * @author 超
 * Create by fengc on  2018/11/4 14:49
 * 一个书本的增删查改类
 */
public class BookServer {

    void create() {
        System.out.println("create()................is running");
    }

    void update() {
        System.out.println("update()................is running");
    }

    void query() {
        System.out.println("query()................is running");
    }

    void delete() {
        System.out.println("delete()................is running");
    }

}
