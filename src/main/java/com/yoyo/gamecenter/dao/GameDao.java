package com.yoyo.gamecenter.dao;

import com.yoyo.gamecenter.model.Game;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/2 0002.
 */
@Repository
public interface GameDao {

    Game selectGameById(@Param("gameId") long gameId);

    Game selectGameByName(@Param("gameName") String gameName);

    List<Game> selectAllGame();

    int addGame(Game game);

    int updateGame(Game game);

    List<Game> selectAllGameByUserId(@Param("uId") long uId, @Param("isDelete") short isDelete);

    List<Game> queryByPage(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize,@Param("isDelete") short isDelete,@Param("text") String text);

    int selectTerminals(@Param("gameId") Long gameId, @Param("terminalNos") List<String> terminalNos);

    int getGameCount(@Param("text") String text,@Param("isDelete") short isDelete);

}
