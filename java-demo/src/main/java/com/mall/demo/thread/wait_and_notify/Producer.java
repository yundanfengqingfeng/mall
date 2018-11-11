package com.mall.demo.thread.wait_and_notify;

/**
 * @author 超
 * Create by fengc on  2018/11/9 23:13
 */
public class Producer implements Runnable {

    private ProductData data;

    public Producer(ProductData data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 30; i ++) {
            data.product(i);
        }
    }
}
