package com.mall.demo.jvm;

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
        StackOverDemo demo = new StackOverDemo();
        demo.funcAdd(0);
    }

    /**
     * 无限递归
     * @param c
     */
    public void funcAdd(int c) {
        System.out.println(c++);
        funcAdd(c);
    }

}
