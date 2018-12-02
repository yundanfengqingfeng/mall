package com.mall.spring.bean;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 超
 * Create by fengc on  2018/12/2 16:29
 */
@Component("person")
public class Person {

    @Resource
    private User user;

    private String unicode ;

    private String[] arrData ;

    private List list;

    private Set set;

    private Map map;

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String[] getArrData() {
        return arrData;
    }

    public void setArrData(String[] arrData) {
        this.arrData = arrData;
    }

    public Person() {
    }

    public Person(User user, String unicode) {
        this.user = user;
        this.unicode = unicode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUnicode() {
        return unicode;
    }

    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

   /* @Override
    public String toString() {
        return "Person{" +
                "user=【" + user.getCode() + "," + user.getAge() + "," + user.getName() +
                "】, unicode='" + unicode + '\'' +
                '}';
    }*/
}
