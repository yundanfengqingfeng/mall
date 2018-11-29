package com.mall.demo;

import com.mall.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class MallDemoApplication {

    @Autowired
    private User user;

    public static void main(String[] args) {

        SpringApplication.run(MallDemoApplication.class, args);
    }
    @Bean
    public void getUser() {
        System.out.println(user);
        user.setAge(11);
        user.setName("你好");

    }
}
