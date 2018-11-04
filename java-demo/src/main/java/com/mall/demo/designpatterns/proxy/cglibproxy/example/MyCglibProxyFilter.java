package com.mall.demo.designpatterns.proxy.cglibproxy.example;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @author 超
 * Create by fengc on  2018/11/4 15:20
 */
public class MyCglibProxyFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        if (!"query".equals(method.getName())) {
            return 0;
        }
        return 1;
    }
}
