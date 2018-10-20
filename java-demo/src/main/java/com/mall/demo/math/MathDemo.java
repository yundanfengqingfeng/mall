package com.mall.demo.math;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-10-19 16:13.
 */
public class MathDemo {


    public static void main(String[] args) {
        int m = 123456789;
        //1.23456792E8
        float n = m;
        float count = m + n;
        double d = n;
        double md = m;
        System.out.println( md);
        double fcount = n + d ;
        System.out.println(count);
        System.out.println(n);
    }

}
