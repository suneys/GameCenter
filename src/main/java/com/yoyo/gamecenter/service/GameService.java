package com.yoyo.gamecenter.service;

import com.yoyo.gamecenter.model.Game;
import com.yoyo.gamecenter.model.Terminal;

import java.util.List;

/**
 * Created by Administrator on 2017/7/2 0002.
 */
public interface GameService {

    Game getGameById(long id);

    Game getGameByName(String name);

    void addGame(Game game);

    void updateGame(Game game);

    List<Game> getAllGames();

    List<Game> getAllGamesByUserId(long uId);

    List<Game> queryByPage(int pageNo,int pageSize,String text);

    void selectTerminals(long gameId, List<String> terminalNos );

    int getGameCount(String text);
}
