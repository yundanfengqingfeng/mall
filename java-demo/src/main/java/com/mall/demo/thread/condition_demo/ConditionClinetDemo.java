package com.mall.demo.thread.condition_demo;

/**
 * @author 超
 * Create by fengc on  2018/11/12 21:50
 */
public class ConditionClinetDemo {

    public static void main(String[] args) {
        Store store = new Store(10);
        new ProductThread(store).start();
        new ProductThread(store).start();
        new ProductThread(store).start();
        new ConsumeThread(store).start();
        new ConsumeThread(store).start();
    }

}
