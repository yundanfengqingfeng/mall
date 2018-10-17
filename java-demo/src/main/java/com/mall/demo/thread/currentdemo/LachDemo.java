package com.mall.demo.thread.currentdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-10-12 09:30.
 *
 * 需求： Java 中模拟并发请求
 * ps:使用for循环进行多开几个线程，那么这种请求一般都存在启动的时候有先后顺序
 *
 * 做法：使用闭锁
 * 1、开启n个线程，加一个闭锁，开启所有线程；
 * 2、待所有线程都准备好后，按下开启按钮，就可以真正的发起并发请求了。
 */
public class LachDemo {

    public static void main(String[] args) throws InterruptedException{
        LachThead lachThead = new LachThead();
        lachThead.startTaskAllInOnce(10,lachThead);
    }
}

class LachThead implements Runnable {

    private AtomicInteger count = new AtomicInteger(0);
    private int total = 0;
    private Integer TATAL_COUNT = 10;

    @Override
    public void run() {
        for (int i = 0 ; i < TATAL_COUNT ; i++) {
            count.incrementAndGet();
            total++;
            System.out.println(System.nanoTime() + "[" + Thread.currentThread().getName() + "],count=" + count.get()+ ",total = " + total);
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public long startTaskAllInOnce(int threadNums,final Runnable task) throws InterruptedException {
        final CountDownLatch startLatch = new CountDownLatch(1);
        final CountDownLatch endLach = new CountDownLatch(threadNums);
        for (int i = 0 ; i < threadNums; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    try{
                        // 使线程在此等待，当开始门打开时，一起涌入门中
                        startLatch.await();
                        try{
                            task.run();
                        } finally {
                            // 将结束门减1，减到0时，就可以开启结束门了
                            endLach.countDown();
                        }
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long statTime = System.nanoTime();
        System.out.println(statTime + "[" + Thread.currentThread().getName() + "] All Thread is ready ,concurrent going.....");
        // 因开启门只需一个开关，所以立马就开启开始门
        startLatch.countDown();
        // 等等结束门开启
        endLach.await();
        long endTime = System.nanoTime();
        System.out.println(endTime + "[" + Thread.currentThread().getName() + "] All Thread is completed" );
        return endTime - statTime;
    }
}
