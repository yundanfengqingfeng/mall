package com.mall.demo.thread.reentrantLock;

/**
 * @author 超
 * Create by fengc on  2018/11/11 22:22
 */
public class LockDemo {

    public static void main(String[] args) {

        AccountWithLock acc = new AccountWithLock();
        new AddThreadWithLock("Pter",acc).start();
        new MinusThreadWithLock("Better",acc).start();
    }

}
