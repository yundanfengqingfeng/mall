package com.mall.demo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author 超
 * Create by fengc on  2018/11/29 22:00
 */
@Configuration
@ConfigurationProperties(prefix = "my")
public class User implements BeanFactoryAware,BeanNameAware,BeanFactoryPostProcessor,ApplicationContextAware,BeanPostProcessor,InitializingBean,DisposableBean {

    private String name;
    private int age;

    private BeanFactory beanFactory;
    private String beanName;
    private ApplicationContext applicationContext;


    public User() {
       System.out.println("【构造器方法】调用 User 实例化......................");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("实现【BeanFactoryAware】的接口调用方法setBeanFactory()............beanFactory=" + beanFactory);
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
        System.out.println("实现【BeanNameAware】的接口调用方法setBeanName()............beanName=" + beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("实现【ApplicationContextAware】setApplicationContext()............applicationContext=" + applicationContext);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("实现【DisposableBean】DisposableBean.destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("实现【InitializingBean】的接口调用方法InitializingBean.afterPropertiesSet()");
    }

 /*   @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("实现【BeanPostProcessor】BeanPostProcessor.postProcessBeforeInitialization(),bean=" + bean + ",beanName = " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("实现【BeanPostProcessor】BeanPostProcessor.postProcessAfterInitialization(),bean=" + bean + ",beanName = " + beanName);
        return bean;
    }*/

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("实现【BeanFactoryPostProcessor】的接口调用方法BeanFactoryPostProcessor.postProcessBeanFactory()");
        BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("user");
        bd.getPropertyValues().addPropertyValue("name", "张三");
    }

    /**
     * 等同于 xml文件中的 init-method=myInit()
     */
    @PostConstruct
    public void myInit() {
        System.out.println("【init-method】,是bean指定的初始化法....................................");
    }

    /**
     * 等同于 xml文件中的 destory-method=myDestory
     */
    @PreDestroy
    public void myDestory() {

        System.out.println("【destroy-method】,是bean销毁后的方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【注入属性】name = " + name );
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("【注入属性】age = " + age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
