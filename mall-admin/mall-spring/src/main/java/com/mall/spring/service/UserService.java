package com.mall.spring.service;

import com.mall.spring.bean.User;

/**
 * @author 超
 * Create by fengc on  2018/12/2 13:58
 */
public interface UserService {

    void addUser();

    void updateUser(String code);

    void delUser(String code);

    User findUserAll();

}
