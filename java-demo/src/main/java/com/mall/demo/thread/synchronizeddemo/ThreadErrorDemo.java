package com.mall.demo.thread.synchronizeddemo;

import java.util.concurrent.CountDownLatch;

/**
 * @author 超
 * Create by fengc on  2018/11/6 23:02
 */
public class ThreadErrorDemo {

    public static void main(String[] args) {

        CountMath countMath = new CountMath();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0 ; i < 50 ; i ++) {
            new AddThread(countMath,countDownLatch).start();
        }
        System.out.println("开始执行线程............");
        countDownLatch.countDown();

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;

        Long g = 3L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g == (a+b));
        System.out.println(g.equals(a+b));

    }

}

class CountMath {

    volatile int count;

    public static final String str = "123";

    public void add () {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count ++;
        System.out.println("当前线程....." + Thread.currentThread().getName() + ".....count = " + count);
    }

}

class AddThread extends Thread {
    CountMath countMath;
    CountDownLatch countDownLatch;
    public AddThread(CountMath countMath, CountDownLatch countDownLatch) {
        this.countMath = countMath;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        //System.out.println("countMath.count = 【" +  countMath.count + "】");
        countMath.add();
    }
}
