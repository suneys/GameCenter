package com.yoyo.gamecenter.service;

import com.yoyo.gamecenter.model.Terminal;

import java.util.List;

/**
 * Created by Administrator on 2017/5/20 0020.
 */
public interface TerminalService {

    List<Terminal> getAllTerminal();

    Terminal getTerminalById(Long id);

    Terminal getTerminalByName(String name);

    Terminal getTerminalByNo(String terminalNo);

    void addTerminal(Terminal terminal);

    void updateTerminal(Terminal terminal);

    List<Terminal> getAllTerminalByUserId(Long uId);

    List<Terminal> queryByPage(Long uId, int pageNo, int pageSize,String text);

    int getTerminalCount(Long uId, String text);


}
