package com.yoyo.gamecenter.dao;

import com.yoyo.gamecenter.model.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/20 0020.
 */
@Repository
public interface ResourceDao {

    Resource selectResourceById(@Param("resourceId") Long resourceId);

    Resource selectResourceByName(@Param("resourceName") String name);

    List<Resource> selectAllResource();

    int addResource(Resource resource);

    int updateResource(Resource resource);

    List<Resource> selectAllResourceByUserId(@Param("uId") long uId,@Param("isDelete") short isDelete);

    List<Resource> selectAllResourceByFileId(@Param("fId") long fId,@Param("isDelete") short isDelete);

    int selectTerminals(@Param("resourceId") Long resourceId, @Param("terminalNos") List<String> terminalNos);

    int getResourceCount(@Param("uId") long uId,@Param("text") String text,@Param("isDelete") short isDelete);

    List<Resource> queryByPage(@Param("uId") long uId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize,@Param("isDelete") short isDelete);

    int getResourceCountInFile(@Param("fId") long fId,@Param("isDelete") short isDelete);

    List<Resource> queryByPageInFile(@Param("fId") long fId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize,@Param("isDelete") short isDelete);
}
