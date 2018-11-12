package com.mall.demo.thread.semaphore_demo;

import java.util.concurrent.Semaphore;

/**
 * @author 超
 * Create by fengc on  2018/11/12 22:18
 * 申请连接对象的类
 */
public class HandleUserThread extends Thread {
    private Semaphore semaphore;
    private String threadName;
    private ConnectionProvide provide;

    public HandleUserThread(Semaphore semaphore, String threadName, ConnectionProvide provide) {
        this.semaphore = semaphore;
        this.threadName = threadName;
        this.provide = provide;
    }

    @Override
    public void run() {
        //通过availablePermits 得到剩余资源
        if (semaphore.availablePermits() > 0) {
            System.out.println(threadName + " permits = " + semaphore.availablePermits());
            System.out.println(threadName + " start, apply the connection.");
        } else {
            System.out.println(threadName + " start, no availbale connection.");
        }
        //通过acquire 为方法申请资源
        try {
            semaphore.acquire();
            provide.provide();
            Thread.sleep(1000);
            System.out.println(threadName + " get Connection.");
            semaphore.release();
            System.out.println(threadName + " release.");
            //使用完数据库后释放该资源
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }
}
