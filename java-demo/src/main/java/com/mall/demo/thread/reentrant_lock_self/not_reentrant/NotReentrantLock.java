package com.mall.demo.thread.reentrant_lock_self.not_reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author 超
 * Create by fengc on  2018/11/19 22:47
 *
 * 实现一把简单的锁
 */
public class NotReentrantLock implements Lock {

    //定义一个变量
    private boolean isLocked = false;

    @Override
    public synchronized void lock() {
        //不断的重复判断，isLock 是否被使用，如果已经被使用，如果已经被占用，
        //则让新进来想尝试获取锁的线程等待,直到被正在运行的锁唤醒
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public synchronized void unlock() {
        //线程释放锁
        isLocked = false;
        //通知所有等待的线程，进行抢占资源，等待的线程只有一个线程能抢到锁
        notifyAll();
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
