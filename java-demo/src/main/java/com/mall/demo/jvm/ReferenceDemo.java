package com.mall.demo.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 超
 * Create by fengc on  2018/10/30 23:15
 */
public class ReferenceDemo {

    public static void main(String[] args) {

       /* A a = new A();
        A b = new A();
        A c = new A();

        b=a;
        System.out.println(b);
        c=b;
        a=c;

        a = null;
        System.out.println(a);
        System.out.println(b);*/


       String a = new String("a");
       String b = new String("b");

       A ab = new A();

        Map map = new HashMap();
        map.put(a,"aaa");
        map.put(b,"bbb");
        map.put(ab,"bbb");
        a = null;
        ab = null;
        System.out.println(map);


    }

}

class A {

}

