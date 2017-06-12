package com.yoyo.gamecenter.service.impl;

import com.yoyo.gamecenter.service.ResourceService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class ResourceServiceImplTest extends TestCase {

    @Resource
    private ResourceService resourceService;

    @Test
    public void getAllResource() throws Exception {

    }

    @Test
    public void getResourceById() throws Exception {

    }

    @Test
    public void getResourceByName() throws Exception {

    }

    @Test
    public void addResource() throws Exception {
       com.yoyo.gamecenter.model.Resource resource = new com.yoyo.gamecenter.model.Resource();
        resource.setFileName("图片3");
        resource.setCreateTime(new Date());
        resourceService.addResource(resource);
    }

    @Test
    public void updateResource() throws Exception {

    }

    @Test
    public void getAllResourceByUserId() throws Exception {

    }

    @Test
    public void selectTerminals() throws Exception {

    }

}