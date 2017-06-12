package com.yoyo.gamecenter.service.impl;


import com.yoyo.gamecenter.dao.UserDao;
import com.yoyo.gamecenter.model.User;
import com.yoyo.gamecenter.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserDao userDao;

    public User getUserById(Long userId) {

        return userDao.selectUserById(userId);
    }

    public User getUserByName(String name) {
        return userDao.selectUserByName(name);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User getUserByPhoneOrEmail(String emailOrPhone) {
        return userDao.selectUserByPhoneOrEmail(emailOrPhone);
    }
    
    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }
}
