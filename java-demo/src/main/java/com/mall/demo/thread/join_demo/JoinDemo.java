package com.mall.demo.thread.join_demo;

/**
 * @author 超
 * Create by fengc on  2018/11/12 22:44
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        JoinThread t1 = new JoinThread("Thread-01");
        JoinThread t2 = new JoinThread("Thread-02");
        JoinThread t3 = new JoinThread("Thread-03");

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();

    }

}
