package com.mall.spring.dao;

import com.mall.spring.bean.User;

/**
 * @author 超
 * Create by fengc on  2018/12/2 14:49
 */
public interface UserDao {

    int saveUser(User user);
    int updateUser(String code);
    int delUser(String code);
    User findUser();
}
