package com.mall.demo.thread.synchronizeddemo;

/**
 * @author 超
 * Create by fengc on  2018/11/6 22:44
 */
public class ThreadError {

   public static void main(String[] args) {
       SynObject object = new SynObject();
       SynThreadAdd add = new SynThreadAdd(object);
       SynThreadAdd add1 = new SynThreadAdd(object);
       SynThreadAdd add2 = new SynThreadAdd(object);
       SynThreadAdd add3 = new SynThreadAdd(object);
       SynThreadMinus minus = new SynThreadMinus(object);
       add.start();
       add1.start();
       add2.start();
       add3.start();
       minus.start();
   }


}
