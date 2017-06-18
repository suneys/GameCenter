package com.yoyo.gamecenter.service.impl;

import com.yoyo.gamecenter.model.AdvFolder;
import com.yoyo.gamecenter.service.AdvFolderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/6/14 0014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class AdvFolderServiceImplTest {

    @Resource
    AdvFolderService advFolderService;
    @Test
    public void getAllAdvFolder() throws Exception {

    }

    @Test
    public void getAdvFolderById() throws Exception {

    }

    @Test
    public void getAdvFolderByName() throws Exception {

    }

    @Test
    public void addAdvFolder() throws Exception {
        AdvFolder advFolder = new AdvFolder();
        advFolder.setCreateDate(new Date());
        advFolder.setIsDelete((short) 0);
        advFolder.setName("图片");
        advFolder.setpId(1);
        advFolder.setuId(6);
        advFolder.setUpdateDate(new Date());
        advFolderService.addAdvFolder(advFolder);
    }

    @Test
    public void updateAdvFolder() throws Exception {

    }

    @Test
    public void getAllAdvFolderByUserId() throws Exception {

    }

}