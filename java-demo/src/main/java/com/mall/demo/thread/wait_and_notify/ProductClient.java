package com.mall.demo.thread.wait_and_notify;

/**
 * @author 超
 * Create by fengc on  2018/11/9 23:21
 */
public class ProductClient {

    public static void main(String[] args) {

        ProductData data = new ProductData();
        new Thread(new Producer(data)).start();
        new Thread(new Consumer(data)).start();


    }

}
