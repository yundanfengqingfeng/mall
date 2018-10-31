package com.mall.demo.jvm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author 超
 * Create by fengc on  2018/10/31 21:28
 * 弱引用的使用了解
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {

        String a = new String("a");
        String b = new String("b");
        Map map = new HashMap(4);
        map.put(a,"aaa");
        map.put(b,"bbb");
        WeakHashMap weakHashMap = new WeakHashMap();
        weakHashMap.put(a,"aaa");
        weakHashMap.put(b,"bbb");
        map.remove(a);
        a = null;
        b = null;
        System.gc();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
           Map.Entry en = (Map.Entry)iterator.next();
           System.out.println("map : key =" + en.getKey() + ",value = " + en.getValue());
        }
        Iterator weakIterator = weakHashMap.entrySet().iterator();
        while (weakIterator.hasNext()) {
            Map.Entry en = (Map.Entry)weakIterator.next();
            System.out.println("weakMap : key =" + en.getKey() + ",value = " + en.getValue());
        }

    }
}
