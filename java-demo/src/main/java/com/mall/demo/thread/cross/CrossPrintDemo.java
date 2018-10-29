package com.mall.demo.thread.cross;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 超
 * Create by fengc on  2018/10/29 22:53
 *需求：
 *     两条线程交叉打印ABABBAAAAAA,共打印100个，每打印10个就停 1 秒钟
 *
 */
public class CrossPrintDemo {
    public static AtomicInteger COUNT = new AtomicInteger(1);
   public static void main(String[] args) {
       for (int i = 0 ; i < 10 ; i++) {
           int FIVE = 5;
           int ONE = 1;
           final CountDownLatch startLatch = new CountDownLatch(ONE);
           final CountDownLatch endLatch = new CountDownLatch(FIVE);
           for (int j = 0 ; j < FIVE ; j ++) {
               new Thread(){
                   @Override
                   public void run() {
                       try {
                           startLatch.await();
                           try {
                               new A("线程" + COUNT.getAndIncrement()).start();
                               new B("线程" + COUNT.getAndIncrement()).start();
                           } finally {
                               endLatch.countDown();
                           }
                       } catch (InterruptedException ie) {
                           ie.printStackTrace();
                       }
                   }
               }.start();
           }
           try {
               startLatch.countDown();
               endLatch.await();
               System.out.println();
               System.out.println("睡眠一秒");
               Thread.sleep(3000);
           } catch (InterruptedException ie) {
               ie.printStackTrace();
           }
       }
   }
}


class A extends Thread {

    public A(String name) {
        super(name);
    }

    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName() +  ":A");
        System.out.print( "A");
    }
}

class B extends Thread {

    public B(String name) {
        super(name);
    }
    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName() +  ":B");
        System.out.print("B");
    }
}