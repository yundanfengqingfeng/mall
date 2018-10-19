package com.mall.demo.classload;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-10-18 15:26.
 * idea 控制台打印GC 日志 -XX:+PrintGCDetails
 */
public class ReferenceCountingGC {

    private Object instance = null;
    private static final int _1MB = 1024 * 1024;

    /** 这个成员属性唯一的作用就是占用一点内存 */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {

        ReferenceCountingGC objectA = new ReferenceCountingGC();
        ReferenceCountingGC objectB = new ReferenceCountingGC();

        objectA.instance = objectB;
        objectB.instance = objectA;

        objectA = null;
        objectB = null;

        System.gc();
    }


}
