package com.yoyo.gamecenter.dao;

import com.yoyo.gamecenter.model.AdvFolder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14 0014.
 */
public interface AdvFolderDao {
    List<AdvFolder> selectAllAdvFolder();

    List<AdvFolder> selectAllAdvFolderByUserId(@Param("uId") long uId,@Param("isDelete") short isDelete);

    AdvFolder selectAdvFolderById(@Param("fId") long fId,@Param("isDelete") short isDelete);

    AdvFolder selectAdvFolderByName(@Param("name") String name,@Param("isDelete") short isDelete);

    int addAdvFolder(AdvFolder advFolder);

    int updateAdvFolder(AdvFolder advFolder);
}
