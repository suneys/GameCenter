package com.yoyo.gamecenter.service;

import com.yoyo.gamecenter.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12 0012.
 */
public interface UserService {
    List<User> getAllUser();

    User getUserByPhoneOrEmail(String emailOrPhone);

    User getUserById(Long userId);

    User getUserByName(String name);

    void addUser(User user);

    void updateUser(User user);
}
