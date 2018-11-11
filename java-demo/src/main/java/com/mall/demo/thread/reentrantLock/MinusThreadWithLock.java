package com.mall.demo.thread.reentrantLock;

/**
 * @author 超
 * Create by fengc on  2018/11/11 22:20
 */
public class MinusThreadWithLock extends Thread {

    String name;
    AccountWithLock acc;

    public MinusThreadWithLock(String name, AccountWithLock acc) {
        this.name = name;
        this.acc = acc;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 30 ; i++) {
            System.out.println(name + ",start  minus money ," + i + ",cnt");
            acc.lockAccount();
            System.out.println(name + ",minus money ," + i + ",cnt");
            acc.login(name);
            acc.minus();
            acc.logout(name);
            acc.unLockAccount();
        }

    }
}
