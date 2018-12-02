package com.mall.spring.service.impl;

import com.mall.spring.bean.Animal;
import com.mall.spring.bean.User;
import com.mall.spring.dao.UserDao;
import com.mall.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author 超
 * Create by fengc on  2018/12/2 13:58
 */
public class UserServiceImpl implements UserService {
    /**
     * 注入的对象
     */
    private UserDao userDao;

    @Autowired
    @Qualifier(value = "animal")
    private Animal animal;

    /**
     * 注入对象，需要使用到setXXX方法
     * @param userDao
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser() {
        animal.setAage("11");
        userDao.saveUser(new User());
        System.out.println("进入了addUser的方法.............");
    }

    @Override
    public void updateUser(String code) {
        System.out.println("进入了updateUser的方法.............");
    }

    @Override
    public void delUser(String code) {
        System.out.println("进入了delUser的方法.............");
    }

    @Override
    public User findUserAll() {
        System.out.println("进入了findUserAll的方法.............");
        User user = null;
        return user;
    }
}
