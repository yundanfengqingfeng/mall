package com.mall.demo.thread.synchronizeddemo;

/**
 * @author 超
 * Create by fengc on  2018/11/6 22:39
 */
public class SynThreadAdd extends Thread {

    SynObject object;

    public SynThreadAdd(SynObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        int count = 0 ;
        while (count < 3) {
            object.add();
            count ++;
        }
    }
}
