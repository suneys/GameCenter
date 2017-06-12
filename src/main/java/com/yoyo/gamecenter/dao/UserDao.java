package com.yoyo.gamecenter.dao;


import com.yoyo.gamecenter.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Repository
public interface UserDao {

    User selectUserById(@Param("userId") Long userId);

    User selectUserByName(@Param("userName") String Name);

    User selectUserByPhoneOrEmail(@Param("emailOrPhone") String emailOrPhone);

    List<User> selectAllUser();

    int addUser(User user);

    int updateUser(User user);
}
