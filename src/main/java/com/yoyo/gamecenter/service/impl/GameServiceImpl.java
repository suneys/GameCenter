package com.yoyo.gamecenter.service.impl;

import com.yoyo.gamecenter.dao.GameDao;
import com.yoyo.gamecenter.model.Game;
import com.yoyo.gamecenter.service.GameService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/7/2 0002.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GameServiceImpl implements GameService {

    @Resource
    GameDao gameDao;

    public Game getGameById(long id) {
        return gameDao.selectGameById(id);
    }

    public Game getGameByName(String name) {
        return gameDao.selectGameByName(name);
    }

    public void addGame(Game game) {
        gameDao.addGame(game);
    }

    public void updateGame(Game game) {
        gameDao.updateGame(game);
    }

    public List<Game> getAllGames() {
        return gameDao.selectAllGame();
    }

    public List<Game> getAllGamesByUserId(long uId) {
        return gameDao.selectAllGameByUserId(uId, (short) 0);
    }

    public List<Game> queryByPage(int pageNo, int pageSize, String text) {
        return gameDao.queryByPage(pageNo,pageSize, (short) 0,text);
    }

    public void selectTerminals(long gameId, List<String> terminalNos) {
        gameDao.selectTerminals(gameId,terminalNos);
    }

    public int getGameCount(String text) {
        return gameDao.getGameCount(text, (short) 0);
    }
}
