package com.mall.demo.thread.synchronizeddemo;

/**
 * @author 超
 * Create by fengc on  2018/11/6 22:41
 */
public class SynThreadMinus extends Thread {

    SynObject object;

    public SynThreadMinus(SynObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        int count = 0 ;
        while (count < 3) {
            object.minus();
            count ++;
        }
    }
}
