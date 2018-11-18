package com.mall.demo.thread.lock_re_enter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 超
 * Create by fengc on  2018/11/18 23:58]
 * 测试Lock 是可重入锁
 * Lock 是重入锁
 */
public class LockReEnter implements Runnable {
    Lock lock = new ReentrantLock(false);

    public void get() {
        lock.lock();
        System.out.println("进入了方法 get()....线程是：" + Thread.currentThread().getName() + "......线程编号：" + Thread.currentThread().getId());
        set();
        lock.unlock();
    }
    public void set() {
        lock.lock();
        System.out.println("进入了方法 set()....线程是：" + Thread.currentThread().getName());
        lock.unlock();
    }

    @Override
    public void run() {
        get();
    }
}
