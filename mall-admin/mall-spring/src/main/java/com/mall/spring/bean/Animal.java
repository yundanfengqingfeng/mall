package com.mall.spring.bean;

import org.springframework.stereotype.Component;

/**
 * @author 超
 * Create by fengc on  2018/12/2 18:10
 */
@Component(value = "animal")
public class Animal {

    private String aname;

    private String aage;

    private String acode;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAage() {
        return aage;
    }

    public void setAage(String aage) {
        this.aage = aage;
    }

    public String getAcode() {
        return acode;
    }

    public void setAcode(String acode) {
        this.acode = acode;
    }
}
