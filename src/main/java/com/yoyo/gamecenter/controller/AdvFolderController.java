package com.yoyo.gamecenter.controller;

import com.yoyo.gamecenter.model.AdvFolder;
import com.yoyo.gamecenter.model.User;
import com.yoyo.gamecenter.service.AdvFolderService;
import com.yoyo.gamecenter.service.ResourceService;
import com.yoyo.gamecenter.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by Administrator on 2017/6/16 0016.
 */
@Controller
@RequestMapping("/folder")
public class AdvFolderController {

    @Resource
    AdvFolderService advFolderService;

    @Resource
    ResourceService resourceService;

    @RequestMapping("/folderList")
    public void folderList(HttpServletRequest request, HttpServletResponse response){
        try {
            Map jsonMap = new HashMap();
            List<Map> dataList = new ArrayList<Map>();
            User user = (User) request.getSession().getAttribute("user");
            List<AdvFolder> advFolders = advFolderService.getAllAdvFolderByUserId(user.getId());
            for (AdvFolder advFolder :
                    advFolders) {
                Map map = new HashMap();
                map.put("id",advFolder.getfId());
                map.put("pId",advFolder.getpId());
                map.put("name",advFolder.getName());
                if(advFolder.getpId() == 0){
                    //根目录 设置根目录的icon
                    map.put("icon",request.getContextPath()+"/images/diy/1_open.png");
                }else{
                    map.put("icon",request.getContextPath()+"/images/diy/10.png");

                }
                dataList.add(map);
            }
            jsonMap.put("rows",dataList);
            ResponseUtil.response(response,jsonMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/edit")
    public void edit(HttpServletRequest request, HttpServletResponse response){
        Map jsonMap = new HashMap();
        try {
            int id = Integer.parseInt(request.getParameter("Id"));
            User user = (User) request.getSession().getAttribute("user");
            String name = request.getParameter("name");
            name = new String(name.getBytes("iso-8859-1"),"UTF-8");
            String type = request.getParameter("type");
            if("1".equals(type)){
                //新增文件夹
                AdvFolder advFolder = new AdvFolder();
                advFolder.setuId(user.getId());
                advFolder.setUpdateDate(new Date());
                advFolder.setpId(id);
                advFolder.setCreateDate(new Date());
                advFolder.setName(name);
                advFolder.setIsDelete((short) 0);
                advFolderService.addAdvFolder(advFolder);
                jsonMap.put("IsOk",true);
            }else{
                //重命名
                AdvFolder advFolder = advFolderService.getAdvFolderById((long) id);
                advFolder.setName(name);
                advFolderService.updateAdvFolder(advFolder);
                jsonMap.put("IsOk",true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonMap.put("IsOk",false);
        }finally {
            ResponseUtil.response(response,jsonMap);
        }
    }

    @RequestMapping("/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response){
        Map jsonMap = new HashMap();
        try {
            int id = Integer.parseInt(request.getParameter("Id"));
            AdvFolder advFolder = advFolderService.getAdvFolderById((long) id);
            advFolder.setIsDelete((short) 1);
            advFolderService.updateAdvFolder(advFolder);
            List<com.yoyo.gamecenter.model.Resource> resources = resourceService.getAllResourceByFileId(id);
            for (com.yoyo.gamecenter.model.Resource resource :
                    resources) {
                resource.setIsDelete((short) 1);
                resourceService.updateResource(resource);
            }
            jsonMap.put("IsOk",true);
        } catch (Exception e) {
            e.printStackTrace();
            jsonMap.put("IsOk",false);
        } finally {
            ResponseUtil.response(response,jsonMap);
        }
    }
}
