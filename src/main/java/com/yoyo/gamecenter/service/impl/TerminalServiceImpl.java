package com.yoyo.gamecenter.service.impl;

import com.github.pagehelper.PageHelper;
import com.yoyo.gamecenter.dao.TermianlDao;
import com.yoyo.gamecenter.model.Terminal;
import com.yoyo.gamecenter.service.TerminalService;
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

    public List<Terminal> getAllTerminal() {
        return termianlDao.selectAllTerminal();
    }

    public Terminal getTerminalById(Long id) {
        return termianlDao.selectTerminalById(id);
    }

    public Terminal getTerminalByName(String name) {
        return termianlDao.selectTerminalByName(name);
    }

    public Terminal getTerminalByNo(String terminalNo) {
        return termianlDao.selectTerminalByNo(terminalNo);
    }

    public void addTerminal(Terminal terminal) {
        termianlDao.addTerminal(terminal);
    }

    public void updateTerminal(Terminal terminal) {
        termianlDao.updateTerminal(terminal);
    }

    public List<Terminal> getAllTerminalByUserId(Long uId) {
        return termianlDao.selectAllTerminalByUserId(uId);
    }

    public List<Terminal> queryByPage(Long uId, int pageNo, int pageSize, String text) {
       // PageHelper.startPage(pageNo,pageSize);
        return termianlDao.queryByPage(uId,pageNo,pageSize,text);
    }

    public int getTerminalCount(Long uId, String text) {
        return termianlDao.getTerminalCount(uId,text);
    }


}
