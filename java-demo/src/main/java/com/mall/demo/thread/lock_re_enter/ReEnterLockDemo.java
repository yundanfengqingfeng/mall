package com.mall.demo.thread.lock_re_enter;

/**
 * @author 超
 * Create by fengc on  2018/11/19 00:09
 * 测试Lock 的可重入性
 */
public class ReEnterLockDemo {

    public static void main(String[] args) {
        LockReEnter lockReEnter = new LockReEnter();
        new Thread(lockReEnter).start();
        new Thread(lockReEnter).start();
        new Thread(lockReEnter).start();
        new Thread(lockReEnter).start();
        new Thread(lockReEnter).start();
        new Thread(lockReEnter).start();
    }

}
