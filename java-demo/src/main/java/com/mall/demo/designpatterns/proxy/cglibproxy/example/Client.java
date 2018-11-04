package com.mall.demo.designpatterns.proxy.cglibproxy.example;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @author 超
 * Create by fengc on  2018/11/4 15:04
 */
public class Client {

    public static void main(String[] args) {

     /*   BookServer bookServer = BookServerFactory.getProxyInstance(new MyCglibProxy("xiaoming"));
        bookServer.create();

        BookServer bookServer1 = BookServerFactory.getProxyInstance(new MyCglibProxy("boss"));
        bookServer1.create();*/

        BookServer boss = BookServerFactory.getProxyFilterInstance(new MyCglibProxy("boss"));
        boss.query();
        boss.create();
        boss.update();
        boss.delete();

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"D:\\IdeaProjects\\mall\\java-demo\\src\\test\\java");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

       /* BookServer xiaoqiang = BookServerFactory.getProxyFilterInstance(new MyCglibProxy("xiaoming"));
        xiaoqiang.create();
        xiaoqiang.query();*/

    }

}
