package com.yoyo.gamecenter.dao;

import com.yoyo.gamecenter.model.Terminal;
import com.yoyo.gamecenter.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/20 0020.
 */
@Repository
public interface TermianlDao {


    Terminal selectTerminalById(@Param("terminalId") Long terminalId);


    Terminal selectTerminalByName(@Param("terminalName") String Name);


    Terminal selectTerminalByNo(@Param("terminalNo") String terminalNo);

    Terminal selectTerminalByNoWithGame(@Param("terminalNo") String terminalNo);


    List<Terminal> selectAllTerminal();

    int selectResources(@Param("terminalNo") String terminalNo, @Param("resourceIds") List<Long> resourceIds);

    int selectGames(@Param("terminalNo") String terminalNo, @Param("gameIds") List<Long> gameIds);

    int addTerminal(Terminal terminal);


    int updateTerminal(Terminal terminal);

    int deleteResources(@Param("terminalNo") String terminalNo);

    int deleteGames(@Param("terminalNo") String terminalNo);

    List<Terminal> selectAllTerminalByUserId(@Param("uId") long uId);


    List<Terminal> queryByPage(@Param("uId") long uId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize, @Param("text") String text);

    int getTerminalCount(@Param("uId") long uId,@Param("text") String text);
}
