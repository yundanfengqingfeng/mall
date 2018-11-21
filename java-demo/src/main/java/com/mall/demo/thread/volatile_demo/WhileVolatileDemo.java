package com.mall.demo.thread.volatile_demo;

/**
 * @author 超
 * Create by fengc on  2018/11/21 22:47
 */
public class WhileVolatileDemo {

    public static void main(String[] args) {
        Flag flag = new Flag();
        int count = 0;
        while (!flag.stop) {
            System.out.println("你好.......count=" + (count++));
        }
        new FlagThread(flag).start();
    }
}

class Flag {
    volatile boolean stop = false;
}

class FlagThread extends Thread {
    Flag flag;

    public FlagThread(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println("进来..........................");
        flag.stop = true;
    }
}
