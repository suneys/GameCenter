package com.yoyo.gamecenter.controller;

import com.yoyo.gamecenter.contant.Content;
import com.yoyo.gamecenter.contant.DataType;
import com.yoyo.gamecenter.model.Game;
import com.yoyo.gamecenter.model.User;
import com.yoyo.gamecenter.service.GameService;
import com.yoyo.gamecenter.utils.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
@Controller
@RequestMapping("/game")
public class GameController {

    @Resource
    GameService gameService;

    @RequestMapping("/addGamePage")
    public String addGamePage(){
        return "Menu/addGame";
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map jsonMap = new HashMap();
            List<Map> dataList = new ArrayList<Map>();
            int pageIndex = Integer.parseInt(request.getParameter("pageIndex")) - 1;
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            int total = gameService.getGameCount(null);
            List<Game> games = gameService.queryByPage(pageIndex * pageSize, pageSize, null);
            for (Game game : games){
                Map map = new HashMap();
                map.put("Id",game.getgId());
                map.put("FileNameStr",game.getGameName());
                map.put("ThumbPath", game.getThumbPath());
                dataList.add(map);
            }
            jsonMap.put("total", total);
            jsonMap.put("rows", dataList);
            ResponseUtil.response(response, jsonMap);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/zengJia")
    public void zengJia(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam MultipartFile file,
                        @RequestParam("gameName") String gameName,
                        @RequestParam("gamePath") String gamePath,
                        @RequestParam("packageName") String packageName
                        ){
        Map jsonMap = new HashMap();
       // MultipartFile file = null;
        try {
            //List<MultipartFile> files = null;
            User user = (User) request.getSession().getAttribute("user");
//            if(request instanceof MultipartHttpServletRequest) {
//               files = ((MultipartHttpServletRequest)request).getFiles("s_file");
//            }
            Game game = new Game();

            game.setGameName(gameName);
            game.setPackageName(packageName);
            game.setPath(gamePath);
            game.setuId(user.getId());
            game.setThumbPath("/Resource/game/game.png");
            if (user != null && file != null) {
//                for (MultipartFile file :
//                        files) {
                    if (file == null) {
                        jsonMap.put("IsOk", false);
                        jsonMap.put("Msg", InfoUtil.GetMsgInfo(1039));
                       // continue;
                    }

                    String strExtension = FileUtil.getExtensionName(file.getOriginalFilename());
                    Content extension = ConvertUtil.getFileExtension(strExtension);
                    if (extension != Content.image) {
                        jsonMap.put("IsOk", false);
                        jsonMap.put("Msg", InfoUtil.GetMsgInfo(1033));
                       // continue;
                    }
                    String strFileName = UUID.randomUUID().toString();
                    String strDate = ConvertUtil.getStrDate(DataType.R);
                    String dirPath = request.getSession().getServletContext().getRealPath("/Resource/game/" + strDate + "/");
                    String path = dirPath + "/" + strFileName + "." + strExtension;  //原图
                    String thumbRealPath = dirPath + "/" + strFileName + "_thumb" + "." + strExtension; //缩略图
                    File dirFile = new File(dirPath);
                    if (!dirFile.exists()) dirFile.mkdirs();
                    File srcFile = new File(path);
                    FileUtil.copyFile(file, srcFile);
                    if(ImageUtil.thumbnailImage(srcFile, 120, 120, thumbRealPath, strExtension)){
                        game.setThumbPath("/Resource/game/" + strDate + "/"+strFileName + "_thumb" + "." + strExtension);
                    }
                }

        //   }
            gameService.addGame(game);
            jsonMap.put("IsOk", true);
        } catch (Exception e) {
            System.out.println(e);
            jsonMap.put("IsOk", false);
            jsonMap.put("Msg", InfoUtil.GetMsgInfo(1001));
        } finally {
            ResponseUtil.response(response, jsonMap);
        }

    }

    @RequestMapping("delete")
    public void delete(HttpServletRequest request, HttpServletResponse response){
        Map jsonMap = new HashMap();
        try {
            String resIds = request.getParameter("resIds");
            String[] ids = resIds.split(",");
            for (int i = 0 ; i < ids.length; i++){
                int id = Integer.parseInt(ids[i]);
                Game game = gameService.getGameById(id);
                game.setG_isDelete((short) 1);
                gameService.updateGame(game);
            }
            jsonMap.put("IsOk",true);
        } catch (Exception e) {
            e.printStackTrace();
            jsonMap.put("IsOk",false);
        }finally {
            ResponseUtil.response(response,jsonMap);
        }
    }

}
