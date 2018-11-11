package com.mall.demo.thread.deadlock;

/**
 * @author 超
 * Create by fengc on  2018/11/10 13:12
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        T t1 = new T();
        T t2 = new T();
        t1.t = t2;
        t2.t = t1;
        t1.start();
        t2.start();
    }

}

class T extends Thread {

    T t;

    @Override
    public void run() {
        synFuncName();
    }

    public synchronized void synFuncName() {
        System.out.println("进入方法synFuncName()..........." + this);
        try {
            sleep(500);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        t.synFunctionOther();
        System.out.println("执行完毕........." + this.getClass());
    }

    public synchronized void synFunctionOther() {
        System.out.println("进入方法.....synFunctionOther()...." + this.getClass());
    }

}