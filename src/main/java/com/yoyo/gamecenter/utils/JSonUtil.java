package com.yoyo.gamecenter.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yoyo.gamecenter.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
public class JSonUtil {

    /**
     * 生成广告列表JSon文件
     * @param terminals
     * @param basePath 项目的根目录
     */
    public static void setAdvList(List<Terminal> terminals,String basePath){

        try {
            for (Terminal terminal :
                    terminals) {
                AdvList advList = new AdvList();
                List<Resource> resources = terminal.getResources();
                List<Adviertisement> advs = new ArrayList<Adviertisement>();
                for (Resource resource :
                        resources) {
                    Adviertisement adviertisement = new Adviertisement();
                    adviertisement.setAdvPath(resource.getPath());
                    adviertisement.setSouceType(resource.getSouceType());
                    if(resource.getSouceType() == 1){
                        adviertisement.setShowTime(VideoUtil.getVideoDuration(basePath + resource.getPath()));
                    }else{
                        adviertisement.setShowTime(2000);
                    }
                    advs.add(adviertisement);
                }
                advList.setAdvs(advs);
                Map jsonMap = new HashMap();
                jsonMap.put("advList",advList);
                String jsonString = JSON.toJSONString(jsonMap);
                String path = basePath + "/advList/"+ terminal.getTerminalNo()+"/playList.json";
                FileUtil.writeToFile(path,jsonString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setGameList(List<Terminal> terminals,String basePath){
        try{
            for (Terminal terminal : terminals){
                GameList gameList = new GameList();
                List<Game> games = terminal.getGames();
                List<PlayGame> playGames = new ArrayList<PlayGame>();
                for (Game game : games){
                    PlayGame playGame = new PlayGame();
                    playGame.setThumbPath(game.getThumbPath());
                    playGame.setPackageName(game.getPackageName());
                    playGame.setGameName(game.getGameName());
                    playGame.setPath(game.getPath());
                    playGames.add(playGame);
                }
                gameList.setPlayGames(playGames);
                Map jsonMap = new HashMap();
                jsonMap.put("gameList",gameList);
                String jsonString = JSON.toJSONString(jsonMap);
                String path = basePath + "/playGameList/"+ terminal.getTerminalNo()+"/playGameList.json";
                FileUtil.writeToFile(path,jsonString);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
