package com.mall.demo.designpatterns.proxy.cglibproxy.example;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * @author 超
 * Create by fengc on  2018/11/4 14:56
 */
public class BookServerFactory {

    private BookServerFactory() {
    }


    static BookServer bookServer = new BookServer();

    /**
     * 普通的对象构建
     */
    public static BookServer getInstance() {
        return bookServer;
    }

    /**
     * cglib 动态代理的对象构建
     * @param cglibProxy
     * @return
     */
    public static BookServer getProxyInstance(MyCglibProxy cglibProxy) {
        return (BookServer)cglibProxy.getProxyBean(BookServer.class);
    }

    /**
     * 加上方法拦截的构建
     */
    public static BookServer getProxyFilterInstance(MyCglibProxy cglibProxy) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BookServer.class);
        /**
         * NoOp.INSTANCE是CGlib所提供的实际是一个没有任何操作的拦截器
         * 他们是有序的,一定要和CallbackFilter里面的顺序一致。当拦截器返回时0 的时候，则按照 NoOp.INSTANCE 进行拦截，也就是没有操作的拦截
         * 当设置为1的时候，则是进行权限拦截
         */
        enhancer.setCallbacks(new Callback[]{cglibProxy,NoOp.INSTANCE});
        //设置方法的拦截器
        enhancer.setCallbackFilter(new MyCglibProxyFilter());
        return (BookServer) enhancer.create();
    }
}
