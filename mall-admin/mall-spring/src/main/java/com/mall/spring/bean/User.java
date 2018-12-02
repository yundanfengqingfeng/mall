package com.mall.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author 超
 * Create by fengc on  2018/12/2 14:00
 */
@Component
public class User {

    public int age;

    String code;

    public String name;

    public User() {

    }

    public User(int age, String code, String name) {
        this.age = age;
        this.code = code;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
