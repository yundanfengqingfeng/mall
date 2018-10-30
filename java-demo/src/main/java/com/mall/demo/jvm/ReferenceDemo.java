package com.mall.demo.jvm;

/**
 * @author 超
 * Create by fengc on  2018/10/30 23:15
 */
public class ReferenceDemo {

    public static void main(String[] args) {

        A a = new A();
        A b = new A();
        A c = new A();

        b=a;
        System.out.println(b);
        c=b;
        a=c;

        a = null;
        System.out.println(a);
        System.out.println(b);

    }

}

class A {}

