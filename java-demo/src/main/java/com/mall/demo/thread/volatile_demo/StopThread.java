package com.mall.demo.thread.volatile_demo;

import java.util.concurrent.TimeUnit;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-11-22 11:35.
 */
public class StopThread {

    private static boolean stopRequsted;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroupThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0 ;
                while (!stopRequsted)
                    System.out.println(i++);
            }
        });
        backgroupThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequsted = true;
    }
}
