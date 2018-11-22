package com.mall.demo.thread.volatile_demo;

/**
 * @author 超
 * Create by fengc on  2018/11/21 22:47
 * 测试 volatile 可见性
 */
public class WhileVolatileDemo implements Runnable {
    volatile static boolean stop = false;
    public static void main(String[] args) {
        int count = 0;
        new Thread(new WhileVolatileDemo()).start();
        new Thread(new WhileVolatileDemo()).start();
        while (!stop) {
            System.out.println("你好.......count=" + (count++) + ",stop = " + stop);
        }
    }
    @Override
    public void run() {
        System.out.println("进来..........................");
        stop = true;
    }
}

