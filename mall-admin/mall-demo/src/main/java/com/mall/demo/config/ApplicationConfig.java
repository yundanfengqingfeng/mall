package com.mall.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-11-24 11:20.
 * 自定义配置文件，自动注入bean
 */
@Configuration
@PropertySource(value = "classpath:application_config.properties")
@ConfigurationProperties(prefix = "com.mall")
public class ApplicationConfig {

    private String name;
    private int age;
    private String project;

    public ApplicationConfig() {
        System.out.println("构造器初始化开始.........ApplicationConfig...............");
    }

    @PostConstruct
    public void init () {
        System.out.println("初始化开始...PostConstruct......ApplicationConfig...............");
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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "ApplicationConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", project='" + project + '\'' +
                '}';
    }
}
