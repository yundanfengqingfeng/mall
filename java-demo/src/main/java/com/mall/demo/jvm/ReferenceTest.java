package com.mall.demo.jvm;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author 超
 * Create by fengc on  2018/10/31 00:06
 * 比较软引用与虚引用的区别
 */
public class ReferenceTest {

    public static void main(String[] args) {
        //强引用
        String str = new String("abc");
        //软引用
        SoftReference<String> softReference = new SoftReference<>(str);
        //去掉强引用
        str = null;
        //通知垃圾回收器进行回收
        System.gc();
        System.out.println(softReference.get());

        //强引用
        String abc = new String("123456");
        //虚引用
        WeakReference<String> weakReference = new WeakReference<>(abc);
        //去掉强引用
        abc = null;
        //通知垃圾回收器进行回收
        System.gc();
        System.out.println(abc);

    }

}
