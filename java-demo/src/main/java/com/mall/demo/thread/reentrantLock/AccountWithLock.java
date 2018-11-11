package com.mall.demo.thread.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 超
 * Create by fengc on  2018/11/11 21:54
 */
public class AccountWithLock {

    //余额
    int balance;
    //锁
    private Lock lock;

    public AccountWithLock() {
       balance = 0 ;
       lock = new ReentrantLock();
    }

    public void lockAccount() {
        lock.lock();
    }
    public void unLockAccount() {
        lock.unlock();
    }
    public void login(String name) {
        System.out.println(name + ",login....................");
    }
    public void logout(String name) {
        System.out.println(name +"，logout....................");
    }
    public void add() {
        balance += 800;
        System.out.println("After add balnce is :" + balance);
    }
    public void minus() {
        balance -= 800;
        System.out.println("After minus balance is:" + balance);
    }
}


