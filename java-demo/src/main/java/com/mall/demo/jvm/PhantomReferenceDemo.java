package com.mall.demo.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author 超
 * Create by fengc on  2018/10/31 22:09
 * 虚引用：
 * 1、虚引用必须和引用队列一起使用
 */
public class PhantomReferenceDemo {

    public static void main(String[] args) {
        //强引用
        String obj = new String("123");
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        PhantomReference<String> phantom = new PhantomReference<>(obj,referenceQueue);
        System.out.println(phantom.get());
    }

}
