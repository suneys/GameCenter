package com.yoyo.gamecenter.service;

import com.yoyo.gamecenter.model.Resource;
import com.yoyo.gamecenter.model.Terminal;

import java.util.List;

/**
 * Created by Administrator on 2017/5/20 0020.
 */
public interface ResourceService {

    List<Resource> getAllResource();

    Resource getResourceById(Long id);

    Resource getResourceByName(String name);

    void addResource(Resource resource);

    void updateResource(Resource resource);

    List<Resource> getAllResourceByUserId(Long uId);

    void selectTerminals(Long resourceId, List<Long> termianlIds);
}
