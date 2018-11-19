package com.mall.demo.thread.reentrant_lock_self.not_reentrant;

import java.util.concurrent.locks.Lock;

/**
 * @author 超
 * Create by fengc on  2018/11/19 23:09
 */
public class NotReentrantLockDemo implements Runnable {

    private static int NUM = 5;
    private Lock lock = new NotReentrantLock();

    public void sayThing(String name) {
        System.out.println(Thread.currentThread().getName() + "线程进来了，需要占用锁.......");
        lock.lock();
        System.out.println("Hello！线程：" + name);
        lock.unlock();
    }

    @Override
    public void run() {
        lock.lock();
        try {
            NUM --;
            System.out.println("线程：" + Thread.currentThread().getName() + "获取到公共锁,number=" + NUM);
            Thread.sleep((long)(Math.random() * 1000));
            sayThing(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        NotReentrantLockDemo demo = new NotReentrantLockDemo();
        for (int i = 0 ; i < NUM ; i++) {
            new Thread(demo,"t"+(i+1)).start();
        }
    }

}
