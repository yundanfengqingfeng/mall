package com.mall.demo.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

/**
 * @author 超
 * Create by fengc on  2018/10/31 22:13
 * 虚引用
 */
public class PhantomReferenceCleaner {

    public static void main(String[] args) {

        String abc = new String("123");
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        PhantomReference<String> ref = new PhantomReference<>(abc,referenceQueue);
        abc = null;
        System.gc();
        //从引用队列中获取待回收的对象
        Object object = referenceQueue.poll();
        if(object != null) {
            Field field = null;
            try {
                field = Reference.class.getDeclaredField("referent");
                field.setAccessible(true);
                System.out.println("Before GC Clear :" + field.get(object).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
