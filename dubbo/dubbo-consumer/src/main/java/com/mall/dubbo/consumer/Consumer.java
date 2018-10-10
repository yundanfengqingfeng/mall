package com.mall.dubbo.consumer;

import com.mall.dubbo.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 超
 * Create by fengc on  2018/10/10 23:32
 */
public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-consumer.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");
        while (true) {
            try{
                Thread.sleep(1000);
                String hello = demoService.sayName("hello world");
                System.out.println(hello);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
