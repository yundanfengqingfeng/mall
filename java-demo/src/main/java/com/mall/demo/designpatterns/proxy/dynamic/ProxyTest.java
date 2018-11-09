package com.mall.demo.designpatterns.proxy.dynamic;

import com.mall.demo.designpatterns.proxy.Person;
import com.mall.demo.designpatterns.proxy.Student;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author 超
 * Create by fengc on  2018/11/1 23:32
 * 使用动态代理
 *
 * Porxy类也是在java.lang.reflect，Proxy 提供用于创建动态代理类和实例的静态方法，它还是由这些方法创建的所有动态代理类的超类。
 *
 */
public class ProxyTest {

    public static void main(String[] args) {

        Person stu = new Student("张三");
        InvocationHandler stuHandler = new StuInvocationHandler<Person>(stu);
       // Person stuProxy = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(),new Class<?>[]{Person.class},stuHandler);
        System.out.println(stu.getClass().getInterfaces());
        Person stuProxy = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(),stu.getClass().getInterfaces(),stuHandler);
        stuProxy.giveMoney();

        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Student.class.getInterfaces());
        String path = "D:\\IdeaProjects\\mall\\java-demo\\src\\test\\java\\StuProxy.class";
        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }
    }

}
