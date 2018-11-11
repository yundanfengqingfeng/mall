package com.mall.demo.thread.BankThreadDemo;

/**
 * @author 超
 * Create by fengc on  2018/11/11 19:12
 */
public class Account {

    int balance;

    public Account() {
        this.balance = 0;
    }

    public synchronized void login(String name) {
        System.out.println(name + " ,进行登录..............");
    }

    public synchronized void logout(String name) {
        System.out.println(name  + "，登录退出了............");
    }

    public synchronized  void add() {
        balance += 800;
        System.out.println("After add balance is :" + balance);
    }

    public synchronized void minus() {
        balance -= 800;
        System.out.println("After minus balance is :" + balance );
    }
}
