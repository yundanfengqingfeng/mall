package com.mall.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-11-23 11:14.
 */
@RestController
public class HelloController {

    @Value("${my.project}")
    private String project;
    @Value("${my.name}")
    private String name;
    @GetMapping("/hello")
    public String hello() {

        return "Hello admin!project=" + project + ",name=" + name ;
    }

}
