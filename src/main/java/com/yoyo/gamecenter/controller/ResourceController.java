package com.yoyo.gamecenter.controller;

import com.yoyo.gamecenter.contant.Content;
import com.yoyo.gamecenter.contant.DataType;
import com.yoyo.gamecenter.dao.ResourceDao;
import com.yoyo.gamecenter.model.User;
import com.yoyo.gamecenter.service.ResourceService;
import com.yoyo.gamecenter.service.UserService;
import com.yoyo.gamecenter.utils.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

/**
 * Created by Administrator on 2017/6/18 0018.
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Resource
    ResourceService resourceService;

    @Resource
    UserService userService;

    @RequestMapping("/list")
    public void list(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map jsonMap = new HashMap();
            List<Map> dataList = new ArrayList<Map>();
            int pageIndex = Integer.parseInt(request.getParameter("pageIndex")) - 1;
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            int fId = Integer.parseInt(request.getParameter("fid"));
            List<com.yoyo.gamecenter.model.Resource> resources = resourceService.queryByPageInFile((long) fId, pageIndex * pageSize, pageSize);
            int total = resourceService.getResourceCountInFile((long) fId);
            User user = (User) request.getSession().getAttribute("user");
            int surplusSize = user.getTotalSize() - user.getUploadSize() > 0 ? user.getTotalSize() - user.getUploadSize() : 0;
            jsonMap.put("total", total);
            jsonMap.put("other", ConvertUtil.convertFileSize(user.getTotalSize())
                    + "|"
                    + ConvertUtil.convertFileSize((surplusSize))
                    + "|"
                    + surplusSize
            );
            for (com.yoyo.gamecenter.model.Resource resource : resources
                    ) {
                Map map = new HashMap();
                map.put("Id", resource.getrId());
                map.put("FileNameStr", resource.getFileName());
                map.put("FileSizeStr", ConvertUtil.convertFileSize(resource.getFileSize()));
                map.put("SouceType", resource.getSouceType());
                map.put("ThumbPath", resource.getThumbPath());
                dataList.add(map);
            }
            jsonMap.put("rows", dataList);
            ResponseUtil.response(response, jsonMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/upload")
    public void upload(MultipartHttpServletRequest request, HttpServletResponse response, @RequestParam("Id") String id) {
        Map jsonMap = new HashMap();
        try {
            User user = (User) request.getSession().getAttribute("user");
            List<MultipartFile> files = request.getFiles("s_file");
            if (user != null && files != null) {
                for (MultipartFile file :
                        files) {
                    int surplus = user.getTotalSize() - user.getUploadSize();
                    if (file == null) {
                        jsonMap.put("IsOk", false);
                        jsonMap.put("Msg", InfoUtil.GetMsgInfo(1039));
                        continue;
                    } else if (file.getSize() > surplus) {
                        jsonMap.put("IsOk", false);
                        jsonMap.put("Msg", InfoUtil.GetMsgInfo(1080).replace("{max}", ConvertUtil.convertFileSize(surplus)));
                        continue;
                    }

                    String strExtension = FileUtil.getExtensionName(file.getOriginalFilename());
                    Content extension = ConvertUtil.getFileExtension(strExtension);
                    if (extension == Content.other) {
                        jsonMap.put("IsOk", false);
                        jsonMap.put("Msg", InfoUtil.GetMsgInfo(1033));
                        continue;
                    }
                    user.setUploadSize((int) (user.getUploadSize() + file.getSize()));
                    String strFileName = UUID.randomUUID().toString();
                    String strDate = ConvertUtil.getStrDate(DataType.R);
                    String dirPath = request.getSession().getServletContext().getRealPath("/Resource/" + extension.toString() + "/" + strDate + "/");
                    String path = dirPath + "/" + strFileName + "." + strExtension;  //原图
                    String thumbPath = dirPath + "/" + strFileName + "_thumb" + "." + strExtension; //缩略图
                    File dirFile = new File(dirPath);
                    if (!dirFile.exists()) dirFile.mkdirs();
                    File srcFile = new File(path);
                    FileUtil.copyFile(file, srcFile);
                    ImageUtil.thumbnailImage(srcFile, 120, 120, thumbPath, strExtension);
                    com.yoyo.gamecenter.model.Resource resource = new com.yoyo.gamecenter.model.Resource();
                    resource.setCreateTime(new Date());
                    resource.setFileName(file.getOriginalFilename());
                    resource.setuId(user.getId());
                    resource.setfId(Long.parseLong(id));
                    resource.setFileSize((int) file.getSize());
                    resource.setPath("/Resource/" + extension.toString() + "/" + strDate  + "/" + strFileName + "." + strExtension);
                    resource.setThumbPath("/Resource/" + extension.toString() + "/" + strDate  + "/" + strFileName + "_thumb" + "." + strExtension);
                    resource.setIsDelete((short) 0);
                    if (extension == Content.image) {
                        resource.setSouceType(0);
                    } else if (extension == Content.video) {
                        resource.setSouceType(1);
                    }
                    resourceService.addResource(resource);
                    jsonMap.put("IsOk", true);
                    jsonMap.put("Msg", thumbPath + "." + strExtension);
                }
                userService.updateUser(user);

            }
        } catch (Exception e) {
            System.out.println(e);
            jsonMap.put("IsOk", false);
            jsonMap.put("Msg", InfoUtil.GetMsgInfo(1001));
        } finally {
            ResponseUtil.response(response, jsonMap);
        }

    }

    @RequestMapping("/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response){
        Map jsonMap = new HashMap();
        try {
            String resIds = request.getParameter("resIds");
            String[] ids = resIds.split(",");
            for (int i = 0 ; i < ids.length; i++){
                int id = Integer.parseInt(ids[i]);
                com.yoyo.gamecenter.model.Resource resource = resourceService.getResourceById((long) id);
                resource.setIsDelete((short) 1);
                resourceService.updateResource(resource);
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
