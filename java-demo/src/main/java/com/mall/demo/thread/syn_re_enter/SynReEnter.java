package com.mall.demo.thread.syn_re_enter;

/**
 * @author 超
 * Create by fengc on  2018/11/18 23:43
 * 测试  synchronized 是否是可重入锁
 * 可重入锁的测试
 */
public class SynReEnter implements Runnable {

    public synchronized void get() {
        System.out.println("进入get()方法....线程编号是：" + Thread.currentThread().getId());
        set();
    }

    public synchronized void set() {
        System.out.println("进入set()方法.....线程编号是：" +  Thread.currentThread().getId());
    }

    @Override
    public void run() {
        get();
    }
}
