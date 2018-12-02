package com.mall.spring.dao.impl;

import com.mall.spring.bean.User;
import com.mall.spring.dao.UserDao;

/**
 * @author 超
 * Create by fengc on  2018/12/2 14:50
 */
public class UserDaoImpl implements UserDao {

    @Override
    public int saveUser(User user) {
        System.out.println("进入了Dao层的saveUser的方法.............");
        return 0;
    }

    @Override
    public int updateUser(String code) {
        System.out.println("进入了Dao层的updateUser的方法.............");
        return 0;
    }

    @Override
    public int delUser(String code) {
        System.out.println("进入了Dao层的delUser的方法.............");
        return 0;
    }

    @Override
    public User findUser() {
        System.out.println("进入了Dao层的findUser的方法.............");
        return null;
    }
}
