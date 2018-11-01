package com.mall.demo.jvm;

import java.io.IOException;

/**
 * @author 超
 * Create by fengc on  2018/10/30 21:23
 *
 * 模拟栈溢出错误 ： 可以无限递归
 *
 * 栈溢出： 当线程请求的栈桢深度大于所允许的深度，将抛出StackOverflowError异常
 *
 */
public class StackOverDemo {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        StackOverDemo demo = new StackOverDemo();
       // demo.funcAdd(0);
        System.out.println("内存空闲值：" + runtime.freeMemory() / 1024L / 1024L + "M");
        System.out.println("最大内存使用值：" + runtime.maxMemory() / 1024L / 1024L + "M");
        System.out.println("内存总值：" + runtime.totalMemory() / 1024L / 1024L + "M");
    }

    /**
     * 无限递归
     * @param c
     */
    public void funcAdd(int c) {
        System.out.println(c++);
        if (c == 1980) {
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        funcAdd(c);
    }

}
