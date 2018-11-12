package com.mall.demo.thread.condition_demo;

/**
 * @author 超
 * Create by fengc on  2018/11/12 21:48
 */
public class ProductThread extends Thread {

    private Store store;

    public ProductThread(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            store.product();
        }
    }
}
