package com.yoyo.gamecenter.service.impl;

import com.yoyo.gamecenter.model.User;
import com.yoyo.gamecenter.service.UserService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/21 0021.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class UserServiceImplTest extends TestCase {

    @Resource
    private UserService userService;

    @Test
    public void testGetUserById() throws Exception {
        User user = userService.getUserById((long) 8);
        System.out.println(user);
    }

    @Test
    public void testGetUserByName() throws Exception {
        User user = userService.getUserByName("13580561190");
        System.out.println(user);
    }

    public void testAddUser() throws Exception {

    }

    public void testUpdateUser() throws Exception {

    }

    @Test
    public void testGetUserByPhoneOrEmail() throws Exception {

        User user = userService.getUserByPhoneOrEmail("13333333333");
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() throws Exception {

        List<User> allUser = userService.getAllUser();
        System.out.println(allUser);
    }

}