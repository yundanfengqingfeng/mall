package com.mall.demo.thread.synchronizeddemo;

/**
 * @author 超
 * Create by fengc on  2018/11/6 22:44
 */
public class ThreadError {

   public static void main(String[] args) {
       SynObject object = new SynObject();
       SynThreadAdd add = new SynThreadAdd(object);
       SynThreadMinus minus = new SynThreadMinus(object);
       add.start();
       minus.start();
   }


}
