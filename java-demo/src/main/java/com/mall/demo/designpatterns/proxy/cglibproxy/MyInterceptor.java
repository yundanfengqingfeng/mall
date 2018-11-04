package com.mall.demo.designpatterns.proxy.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 超
 * Create by fengc on  2018/11/3 22:36
 */
public class MyInterceptor implements MethodInterceptor {

    /**
     * 拦截方法
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("被代理方法调用前.................start....");
        Object object =  methodProxy.invokeSuper(o,objects);
        System.out.println("被代理方法调用前.................end....");
        return object;
    }
}
