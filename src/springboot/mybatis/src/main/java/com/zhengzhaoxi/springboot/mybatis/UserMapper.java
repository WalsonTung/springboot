package com.zhengzhaoxi.springboot.mybatis;

import java.util.List;

import com.zhengzhaoxi.springboot.model.User;

public interface UserMapper {

    List<User> findAll();

    User getById(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}
