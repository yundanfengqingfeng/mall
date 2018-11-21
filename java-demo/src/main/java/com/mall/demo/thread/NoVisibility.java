package com.mall.demo.thread;

/**
 * @author 超
 * Create by fengc on  2018/11/21 21:33
 * 演示执行的排序性
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderRunable implements Runnable {
        @Override
        public void run() {
            int count = 0;
            while (!ready) {
                Thread.yield();
                System.out.println("count = " + (count++));
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        number = 10;
        ready = true;
        new Thread(new ReaderRunable()).start();
    }
}
