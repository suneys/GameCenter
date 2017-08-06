package com.yoyo.gamecenter.service.impl;

import com.yoyo.gamecenter.model.Game;
import com.yoyo.gamecenter.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/2 0002.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class GameServiceImplTest {

    @Resource
    GameService gameService;
    @Test
    public void getGameById() throws Exception {

    }

    @Test
    public void getGameByName() throws Exception {

    }

    @Test
    public void addGame() throws Exception {
        Game game = new Game();
        game.setGameName("王者荣耀");
        game.setPackageName("com.tencen.wz");
        gameService.addGame(game);
    }

    @Test
    public void updateGame() throws Exception {

    }

    @Test
    public void getAllGames() throws Exception {

    }

    @Test
    public void getAllGamesByUserId() throws Exception {

    }

    @Test
    public void queryByPage() throws Exception {

    }

    @Test
    public void selectTerminals() throws Exception {

    }

    @Test
    public void getGameCount() throws Exception {

    }

}