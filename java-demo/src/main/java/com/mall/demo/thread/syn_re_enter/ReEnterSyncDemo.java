package com.mall.demo.thread.syn_re_enter;

/**
 * @author 超
 * Create by fengc on  2018/11/18 23:55
 */
public class ReEnterSyncDemo {

    public static void main(String[] args) {
        SynReEnter synReEnter = new SynReEnter();
        new Thread(synReEnter).start();
        new Thread(synReEnter).start();
    }

}
