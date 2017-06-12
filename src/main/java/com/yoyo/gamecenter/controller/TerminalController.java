package com.yoyo.gamecenter.controller;

import com.yoyo.gamecenter.model.Terminal;
import com.yoyo.gamecenter.model.User;
import com.yoyo.gamecenter.service.ResourceService;
import com.yoyo.gamecenter.service.TerminalService;
import com.yoyo.gamecenter.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by Administrator on 2017/6/9 0009.
 */
@Controller
@RequestMapping("/terminal")
public class TerminalController {

    @Resource
    TerminalService terminalService;

    @RequestMapping("/list")
    public void list(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map jsonMap = new HashMap();
            List<Map> dataList = new ArrayList<Map>();
            User user = (User) request.getSession().getAttribute("user");
            int pageSize = Integer.parseInt(request.getParameter("rows"));
            int pageNo = Integer.parseInt(request.getParameter("page")) - 1;
            String searchName = request.getParameter("SearchName");
            String text = searchName.equals("") ? null : searchName;
            if (text != null){
                text = text.trim();
            }
            List<Terminal> terminals = terminalService.queryByPage(user.getId(), pageNo * pageSize, pageSize, text);
            for (Terminal terminal : terminals) {
                Map map = new HashMap();
                map.put("TerminalNo", terminal.getTerminalNo());
                map.put("TerminalName", terminal.getTerminalName());

                List<com.yoyo.gamecenter.model.Resource> resources = terminal.getResources();
                StringBuilder resourceName = new StringBuilder();
                for (com.yoyo.gamecenter.model.Resource resource : resources){
                    if (resource.getrId() == 0){
                        resourceName.append("无广告");
                    }else {
                        resourceName.append(resource.getFileName() + ",");
                    }
                }
                map.put("SourceName",resourceName.toString());

                map.put("CreateDateStr",new Date());
                map.put("PublishStateStr",terminal.getPublishState());
                dataList.add(map);
            }
            int total = terminalService.getTerminalCount(user.getId(),text);
            jsonMap.put("total",total);
            jsonMap.put("rows",dataList);
            ResponseUtil.response(response,jsonMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/editName")
    public void editName(HttpServletRequest request, HttpServletResponse response){
        Map jsonMap = new HashMap();
        try {
            String terminalNo = request.getParameter("TerminalNo");
            String name = request.getParameter("N");
            name = new String(name.getBytes("iso-8859-1"),"UTF-8");
            Terminal terminal = terminalService.getTerminalByNo(terminalNo.trim());
            terminal.setTerminalName(name);
            terminalService.updateTerminal(terminal);
            jsonMap.put("IsOk",true);
        } catch (Exception e) {
            e.printStackTrace();
            jsonMap.put("IsOk",false);
        } finally {
            ResponseUtil.response(response,jsonMap);
        }

    }
}
