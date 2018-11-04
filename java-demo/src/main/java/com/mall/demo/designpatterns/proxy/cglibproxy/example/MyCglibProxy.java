package com.mall.demo.designpatterns.proxy.cglibproxy.example;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 超
 * Create by fengc on  2018/11/4 15:02
 * Cglib 的动态代理复写
 */
public class MyCglibProxy implements MethodInterceptor {

    Enhancer enhancer = new Enhancer();

    String name;
    public MyCglibProxy(String name) {
        this.name = name;
    }

    public Object getProxyBean(Class cl) {
        enhancer.setSuperclass(cl);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"D:\\IdeaProjects\\mall\\java-demo\\src\\test\\java");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.out.println("执行者是.................名字=:【." + name + "】");
        if (!"boss".equals(name)) {
            System.out.println("你不是老板呀，没权限!");
            return null;
        }
       return methodProxy.invokeSuper(o,objects);
    }

}
