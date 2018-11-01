package com.mall.demo.designpatterns.proxy.dynamic;

/**
 * @author 超
 * Create by fengc on  2018/11/1 23:25
 */
public class MonitorUtils {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void start(String methodName) {
        System.out.println("代理正在执行的方法：" + methodName);
        threadLocal.set(System.currentTimeMillis());
    }

    public static void finish(String methodName){
        System.out.println("方法耗时：" + (System.currentTimeMillis() - threadLocal.get()));
    }

}
