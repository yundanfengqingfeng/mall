package com.mall.demo.thread.condition_demo;

import com.mall.demo.thread.deadlock.THreadDead;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 超
 * Create by fengc on  2018/11/12 21:22
 */
public class Store {

    /**
     * 锁
     */
    private Lock lock;
    private Condition notFull;
    private Condition notEmpty;
    private int maxSize;
    private LinkedList<String> storage;

    public Store(int maxSize) {
        lock = new ReentrantLock(false);
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
        this.maxSize = maxSize;
        storage = new LinkedList<>();
    }

    /**
     * 生产方法
     */
    public void product() {
        lock.lock();
        try {
            //仓库满了
            while (storage.size() == maxSize) {
                System.out.println(Thread.currentThread().getName() + ":wait");
                notFull.await();
            }
            storage.add("Java Book");
            System.out.println(Thread.currentThread().getName() + ": put :" + storage.size());
            Thread.sleep(1000);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    /**
     * 消费方法
     */
    public void consume() {
        lock.lock();
        try {
            while (storage.size() == 0) {
                System.out.println(Thread.currentThread().getName() + ":wait");
                notEmpty.await();
            }
            System.out.println(Thread.currentThread().getName() + "，poll: " + storage.poll());
            Thread.sleep(1000);
            notFull.signalAll();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
