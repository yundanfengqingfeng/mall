package com.mall.demo.designpatterns.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 超
 * Create by fengc on  2018/11/1 23:28
 */
public class StuInvocationHandler<T> implements InvocationHandler {

    T target;

    public StuInvocationHandler(T target) {
        this.target = target;
    }

    /**
     * 代理反射类复写
     * @param proxy 代表动态代理对象
     * @param method 代表正在执行的方法
     * @param args 代表目标方法传入的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MonitorUtils.start(method.getName());
        Object result = method.invoke(target,args);
        MonitorUtils.finish(method.getName());
        return result;
    }
}
