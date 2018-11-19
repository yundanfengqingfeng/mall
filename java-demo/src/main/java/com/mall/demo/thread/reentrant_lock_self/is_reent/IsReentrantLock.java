package com.mall.demo.thread.reentrant_lock_self.is_reent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author 超
 * Create by fengc on  2018/11/19 23:21
 * 自己实现一把可重入锁
 */
public class IsReentrantLock implements Lock {

    /**
     * 定义一个变量，标记锁是否被使用
     */
    private boolean isLocked = false;
    /**
     * 第一次线程进来的时候，正在运行的线程为null
     */
    private Thread runningThread = null;
    //同一个线程进入一把锁的计数器
    private int count = 0;

    @Override
    public void lock() {

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
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
