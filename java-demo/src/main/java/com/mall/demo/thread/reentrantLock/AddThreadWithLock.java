package com.mall.demo.thread.reentrantLock;

/**
 * @author 超
 * Create by fengc on  2018/11/11 22:14
 */
public class AddThreadWithLock extends Thread {

    String name;
    AccountWithLock acc;

    public AddThreadWithLock(String name, AccountWithLock acc) {
        this.name = name;
        this.acc = acc;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 30 ; i++) {
            System.out.println(name + ",start  add money ," + i + ",cnt");
            acc.lockAccount();
            System.out.println(name + ", add money ," + i + ",cnt");
            acc.login(name);
            acc.add();
            acc.logout(name);

            acc.unLockAccount();
        }
    }
}
