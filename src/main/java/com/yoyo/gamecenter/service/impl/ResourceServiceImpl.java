package com.yoyo.gamecenter.service.impl;

import com.yoyo.gamecenter.dao.ResourceDao;
import com.yoyo.gamecenter.model.Resource;
import com.yoyo.gamecenter.service.ResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/5 0005.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceServiceImpl implements ResourceService {

    @javax.annotation.Resource
    private ResourceDao resourceDao;

    public List<Resource> getAllResource() {
        return resourceDao.selectAllResource();
    }

    public Resource getResourceById(Long id) {
        return resourceDao.selectResourceById(id);
    }

    public Resource getResourceByName(String name) {
        return resourceDao.selectResourceByName(name);
    }

    public void addResource(Resource resource) {
        resourceDao.addResource(resource);
    }

    public void updateResource(Resource resource) {
        resourceDao.updateResource(resource);
    }

    public List<Resource> getAllResourceByUserId(Long uId) {
        return resourceDao.selectAllResourceByUserId(uId);
    }

    public void selectTerminals(Long resourceId, List<Long> termianlIds) {
        resourceDao.selectTerminals(resourceId,termianlIds);
    }
}
