package com.yoyo.gamecenter.controller;

import com.yoyo.gamecenter.dao.ResourceDao;
import com.yoyo.gamecenter.model.User;
import com.yoyo.gamecenter.service.ResourceService;
import com.yoyo.gamecenter.utils.ConvertUtil;
import com.yoyo.gamecenter.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/18 0018.
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Resource
    ResourceService resourceService;

    @RequestMapping("/list")
    public void list(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map jsonMap = new HashMap();
            List<Map> dataList = new ArrayList<Map>();
            int pageIndex = Integer.parseInt(request.getParameter("pageIndex")) - 1;
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            int fId = Integer.parseInt(request.getParameter("fid"));
            List<com.yoyo.gamecenter.model.Resource> resources = resourceService.queryByPageInFile((long) fId, (pageIndex + pageIndex * pageSize), pageSize);
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
            for (com.yoyo.gamecenter.model.Resource resource: resources
                 ) {
                Map map = new HashMap();
                map.put("Id",resource.getfId());
                map.put("FileNameStr",resource.getFileName());
                map.put("FileSizeStr",ConvertUtil.convertFileSize(resource.getFileSize()));
                map.put("SouceType",ConvertUtil.getSourceTypeName(resource.getSouceType()));
                dataList.add(map);
            }
            jsonMap.put("rows",dataList);
            ResponseUtil.response(response,jsonMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/upload")
    public void upload(@RequestParam("s_file") CommonsMultipartFile mFile, @RequestParam("Id") String id) {
        if (!mFile.isEmpty()) {

        }
    }
}
