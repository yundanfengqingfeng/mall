package com.mall.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 超
 * Create by fengc on  2018/10/10 22:48
 */
public class Provider {

    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-provider.xml"});
        context.start();
        System.in.read();
    }

}
