package com.yoyo.gamecenter.dao;

import com.yoyo.gamecenter.model.Terminal;
import com.yoyo.gamecenter.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/20 0020.
 */
public interface TermianlDao {

    Terminal selectTerminalById(@Param("terminalId") Long terminalId);

    Terminal selectTerminalByName(@Param("terminalName") String Name);

    Terminal selectTerminalByNo(@Param("terminalNo") String terminalNo);

    List<Terminal> selectAllTerminal();

    int addTerminal(Terminal terminal);

    int updateTerminal(Terminal terminal);

    List<Terminal> selectAllTerminalByUserId(@Param("uId") long uId);

    List<Terminal> queryByPage(@Param("uId") long uId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize, @Param("text") String text);

    int getTerminalCount(@Param("uId") long uId,@Param("text") String text);
}
