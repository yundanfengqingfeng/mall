package com.mall.demo.thread.thread_group_demo;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-11-22 14:25.
 */
public class GroupDemo {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup().getName());

        new Thread(new ThreadGroup("unsafe"), new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getThreadGroup().getName());
            }
        }).start();

    }

}
