package com.mall.demo.thread.semaphore_demo;

import java.util.concurrent.Semaphore;

/**
 * @author 超
 * Create by fengc on  2018/11/12 22:26
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        ConnectionProvide provide =  new ConnectionProvide();
        Semaphore semaphore = new Semaphore(2,true);
        for (int i = 0 ; i < 10 ; i++) {
            new HandleUserThread(semaphore,Integer.valueOf(i).toString(),provide).start();
        }
    }

}
