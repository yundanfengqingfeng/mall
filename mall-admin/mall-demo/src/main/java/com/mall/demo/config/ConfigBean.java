package com.mall.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-11-24 11:00.
 */
@Configuration
@ConfigurationProperties(prefix = "my")
public class ConfigBean {

    private String name;
    private int age;
    private int number;
    private String uuid;
    private int max;
    private String value;
    private String geeting;

    @Override
    public String toString() {
        return "ConfigBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number=" + number +
                ", uuid='" + uuid + '\'' +
                ", max=" + max +
                ", value='" + value + '\'' +
                ", greeting='" + geeting + '\'' +
                '}';
    }

    public ConfigBean() {
        System.out.println("构造器初始化开始.........ConfigBean...............");
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化开始.........ConfigBean...............");
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getGeeting() {
        return geeting;
    }

    public void setGeeting(String geeting) {
        this.geeting = geeting;
    }
}
