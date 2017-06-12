package com.yoyo.gamecenter.dao;

import com.yoyo.gamecenter.model.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/20 0020.
 */
public interface ResourceDao {

    Resource selectResourceById(@Param("resourceId") Long resourceId);

    Resource selectResourceByName(@Param("resourceName") String name);

    List<Resource> selectAllResource();

    int addResource(Resource resource);

    int updateResource(Resource resource);

    List<Resource> selectAllResourceByUserId(@Param("uId") long uId);

    int selectTerminals(@Param("resourceId") Long resourceId, @Param("terminalIds") List<Long> terminalIds);
}
