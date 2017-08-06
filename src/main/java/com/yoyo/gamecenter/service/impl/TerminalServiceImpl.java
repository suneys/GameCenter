package com.yoyo.gamecenter.service.impl;

import com.github.pagehelper.PageHelper;
import com.yoyo.gamecenter.dao.TermianlDao;
import com.yoyo.gamecenter.model.Terminal;
import com.yoyo.gamecenter.service.TerminalService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/20 0020.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TerminalServiceImpl implements TerminalService {

    @Resource
    private TermianlDao termianlDao;

    @Cacheable(value = "myCache",key = "AllTerminal")
    public List<Terminal> getAllTerminal() {
        return termianlDao.selectAllTerminal();
    }

    @Cacheable(value = "myCache",key = "#id")   //把返回的结果加到缓存中，提高效率
    public Terminal getTerminalById(Long id) {
        return termianlDao.selectTerminalById(id);
    }

    @Cacheable(value = "myCache", key = "#name")
    public Terminal getTerminalByName(String name) {
        return termianlDao.selectTerminalByName(name);
    }

    @Cacheable(value = "myCache", key = "#terminalNo")
    public Terminal getTerminalByNo(String terminalNo) {
        return termianlDao.selectTerminalByNo(terminalNo);
    }

    public Terminal getTerminalByNoWithGame(String terminalNo) {
        return termianlDao.selectTerminalByNoWithGame(terminalNo);
    }

    @CacheEvict(value = "myCache",allEntries = true,beforeInvocation = true)
    public void addTerminal(Terminal terminal) {
        termianlDao.addTerminal(terminal);
    }

    @CacheEvict(value = "myCache",allEntries = true,beforeInvocation = true)
    public void updateTerminal(Terminal terminal) {
        termianlDao.updateTerminal(terminal);
    }

    @CacheEvict(value = "myCache",key = "#terminalNo",beforeInvocation = true)
    public void selectResources(String terminalNo, List<Long> resourceIds) {
        termianlDao.selectResources(terminalNo,resourceIds);
    }

    public void deleteResources(String terminalNo) {
        termianlDao.deleteResources(terminalNo);
    }

    public void selectGames(String terminalNo, List<Long> gameIds){
        termianlDao.selectGames(terminalNo,gameIds);
    }

    public void deleteGames(String terminalNo){
        termianlDao.deleteGames(terminalNo);
    }

    public List<Terminal> getAllTerminalByUserId(Long uId) {
        return termianlDao.selectAllTerminalByUserId(uId);
    }

    @Cacheable(value = "myCache",key = "#uId + #pageNo")
    public List<Terminal> queryByPage(Long uId, int pageNo, int pageSize, String text) {
       // PageHelper.startPage(pageNo,pageSize);
        return termianlDao.queryByPage(uId,pageNo,pageSize,text);
    }

    public int getTerminalCount(Long uId, String text) {
        return termianlDao.getTerminalCount(uId,text);
    }


}
