package com.mall.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-11-24 11:00.
 */
@ConfigurationProperties(prefix = "my")
@Component
public class ConfigBeanOther {

    private String name;
    private int age;


    @Override
    public String toString() {
        return "ConfigBeanOther{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public ConfigBeanOther() {
        System.out.println("构造器初始化开始.........ConfigBeanOther...............");
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化开始.........ConfigBeanOther...............");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
