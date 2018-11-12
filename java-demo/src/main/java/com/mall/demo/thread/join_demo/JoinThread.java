package com.mall.demo.thread.join_demo;

/**
 * @author 超
 * Create by fengc on  2018/11/12 22:43
 */
public class JoinThread  extends Thread {

    String name;

    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ".start ........................");
    }
}
