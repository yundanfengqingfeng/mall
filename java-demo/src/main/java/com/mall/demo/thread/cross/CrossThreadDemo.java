package com.mall.demo.thread.cross;

/**
 * @author 超
 * Create by fengc on  2018/10/29 23:39
 * 两条线程交叉打印
 */
public class CrossThreadDemo {

    public static void main(String[] args) {
        
        new Thread(new DemoThread(),"A").start();
        new Thread(new DemoThread(),"B").start();
    }

}

class DemoThread implements Runnable {


    @Override
    public void run() {

        System.out.print(Thread.currentThread().getName());
    }
}
