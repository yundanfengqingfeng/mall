package com.mall.demo.thread.BankThreadDemo;

/**
 * @author 超
 * Create by fengc on  2018/11/11 19:13
 */
public class SyncLimit {

    public static void main(String[] args) {
        Account account = new Account();

        new AddThread("Pter",account).start();
        new MinusThread("Betty",account).start();
    }

}
