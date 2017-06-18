package com.yoyo.gamecenter.service;

import com.yoyo.gamecenter.model.AdvFolder;
import com.yoyo.gamecenter.model.Resource;

import java.util.List;

/**
 * Created by Administrator on 2017/5/20 0020.
 */
public interface AdvFolderService {

    List<AdvFolder> getAllAdvFolder();

    AdvFolder getAdvFolderById(Long id);

    AdvFolder getAdvFolderByName(String name);

    void addAdvFolder(AdvFolder advFolder);

    void updateAdvFolder(AdvFolder advFolder);

    List<AdvFolder> getAllAdvFolderByUserId(Long uId);

}
