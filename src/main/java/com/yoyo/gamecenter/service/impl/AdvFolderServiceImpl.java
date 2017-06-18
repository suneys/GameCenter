package com.yoyo.gamecenter.service.impl;

import com.yoyo.gamecenter.dao.AdvFolderDao;
import com.yoyo.gamecenter.model.AdvFolder;
import com.yoyo.gamecenter.service.AdvFolderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/6/5 0005.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AdvFolderServiceImpl implements AdvFolderService {

    @Resource
    AdvFolderDao advFolderDao;

    public List<AdvFolder> getAllAdvFolder() {
        return advFolderDao.selectAllAdvFolder();
    }

    public AdvFolder getAdvFolderById(Long id) {
        return advFolderDao.selectAdvFolderById(id, (short) 0);
    }

    public AdvFolder getAdvFolderByName(String name) {
        return advFolderDao.selectAdvFolderByName(name, (short) 0);
    }

    public void addAdvFolder(AdvFolder advFolder) {
        advFolderDao.addAdvFolder(advFolder);
    }

    public void updateAdvFolder(AdvFolder advFolder) {
        advFolderDao.updateAdvFolder(advFolder);
    }

    public List<AdvFolder> getAllAdvFolderByUserId(Long uId) {
        return advFolderDao.selectAllAdvFolderByUserId(uId, (short) 0);
    }
}
