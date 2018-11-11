package com.mall.demo.thread.wait_and_notify;

/**
 * @author 超
 * Create by fengc on  2018/11/9 23:13
 */
public class Consumer implements Runnable {

    ProductData data;

    public Consumer(ProductData data) {
        this.data = data;
    }

    @Override
    public void run() {
        int i = 0;
        do {
            data.consume();
            i++;
        } while (i <50);
    }
}
