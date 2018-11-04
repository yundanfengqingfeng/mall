package com.mall.demo.designpatterns.proxy.cglibproxy;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author 超
 * Create by fengc on  2018/11/3 22:42
 *
 *CGLIB 的动态代理实现
 */
public class CglibProxyClient {

    public static void main(String[] args) {
        //代理类class文件存入本地磁盘
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"D:\\IdeaProjects\\mall\\java-demo\\src\\test\\java");
        Enhancer en = new Enhancer();
        en.setSuperclass(Boy.class);
        en.setCallback(new MyInterceptor());
        Boy boy = (Boy)en.create();
        boy.funName("小南");
        boy.funAge(11);
    }

}
