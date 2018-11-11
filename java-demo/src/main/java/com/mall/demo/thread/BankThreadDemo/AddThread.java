package com.mall.demo.thread.BankThreadDemo;

/**
 * @author 超
 * Create by fengc on  2018/11/11 19:12
 */
public class AddThread extends Thread {

    String name;
    Account account;

    public AddThread(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 3 ; i++) {
            System.out.println(name +  ",add money ," + i + ",cnt");
            account.login(name);
            try {
                sleep(2000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            account.add();
            account.login(name);
        }

    }

}
