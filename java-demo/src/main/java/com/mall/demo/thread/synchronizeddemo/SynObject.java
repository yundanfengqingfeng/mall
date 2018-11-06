package com.mall.demo.thread.synchronizeddemo;

/**
 * @author 超
 * Create by fengc on  2018/11/6 22:35
 */
public class SynObject {

    int i;
    int j;

    public synchronized void add() {
        i++;
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j++;
        System.out.println("Operation : + Data :i = " + i + ",j= " + j );
    }

    public synchronized void minus() {
        i--;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j--;
        System.out.println("Operation : - Data : i = " + i + ",j = " +j);
    }

}
