package com.yoyo.gamecenter.controller;

import com.yoyo.gamecenter.contant.DataType;
import com.yoyo.gamecenter.model.Terminal;
import com.yoyo.gamecenter.model.User;
import com.yoyo.gamecenter.service.ResourceService;
import com.yoyo.gamecenter.service.TerminalService;
import com.yoyo.gamecenter.utils.ConvertUtil;
import com.yoyo.gamecenter.utils.DateUtil;
import com.yoyo.gamecenter.utils.JSonUtil;
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

                List<com.yoyo.gamecenter.model.Resource> resources = terminalService.getTerminalByNo(terminal.getTerminalNo()).getResources();
                StringBuilder resourceName = new StringBuilder();
                if (resources != null) {
                    for (com.yoyo.gamecenter.model.Resource resource : resources) {
                        if (resource.getrId() == 0) {
                            resourceName.append("无广告");
                        } else {
                            resourceName.append(resource.getFileName() + ",");
                        }
                    }
                    map.put("SourceName", resourceName.toString());


                }
                map.put("CreateDateStr", DateUtil.convertDateTime(terminal.getCreateDate()));
                map.put("PublishStateStr", ConvertUtil.getPublishStateName(terminal.getPublishState()));
                map.put("PublishState",terminal.getPublishState());
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

    @RequestMapping("/send")
    public void send(HttpServletRequest request, HttpServletResponse response){
        Map jsonMap = new HashMap();
        try {
            String programmeId = request.getParameter("ProgrammeId");
            String terminalNo = request.getParameter("TerminalNo");
            int type = Integer.parseInt(request.getParameter("type"));
            User user = (User) request.getSession().getAttribute("user");
            String[] programmeIds = programmeId.split(",");
            String[] terminalNos = terminalNo.split(",");
            List<Long> resourceIds = new ArrayList<Long>();
            List<Terminal> terminals = new ArrayList<Terminal>();
            for (int i = 0; i < programmeIds.length; i++){
                resourceIds.add(Long.parseLong(programmeIds[i]));
            }
            for (int i = 0; i < terminalNos.length; i++){
                if(type == 1) {
                    terminalService.deleteResources(terminalNos[i]);
                    terminalService.selectResources(terminalNos[i], resourceIds);
                }else if(type == 2){
                    terminalService.deleteGames(terminalNos[i]);
                    terminalService.selectGames(terminalNos[i], resourceIds);
                }
            }
            for (int i = 0; i < terminalNos.length; i++){
                Terminal terminal = null;
                if(type == 1) {
                    terminal = terminalService.getTerminalByNo(terminalNos[i]);
                }else if(type == 2){
                    terminal = terminalService.getTerminalByNoWithGame(terminalNos[i]);
                }
                if(terminal != null) {
                    terminal.setCreateDate(new Date());
                    terminal.setPublishState((short) 2);
                    terminalService.updateTerminal(terminal);
                    terminals.add(terminal);
                }
            }
            if(type == 1) {
                JSonUtil.setAdvList(terminals, request.getSession().getServletContext().getRealPath("/"));
            }else if(type == 2){
                JSonUtil.setGameList(terminals, request.getSession().getServletContext().getRealPath("/"));
            }
            jsonMap.put("IsOk",true);
            jsonMap.put("BackURL","成功发布"+resourceIds.size()+"个资源");
        } catch (Exception e) {
            e.printStackTrace();
            jsonMap.put("IsOk",false);
        } finally {
            ResponseUtil.response(response,jsonMap);
        }
    }

    @RequestMapping("/register")
    public void register(HttpServletRequest request, HttpServletResponse response){
        Map jsonMap = new HashMap();
        String terminalNo = request.getParameter("TerminalNo");
        Terminal terminal = terminalService.getTerminalByNo(terminalNo);
        if(terminal == null) {
            terminal = new Terminal();
            terminal.setCreateDate(new Date());
            terminal.setTerminalName(terminalNo);
            terminal.setIsDelete((short) 0);
            terminal.setPublishState((short) 0);
            terminal.setTerminalNo(terminalNo);
            terminalService.addTerminal(terminal);
            jsonMap.put("IsOk",true);
        }else{
            jsonMap.put("IsOk",false);
            jsonMap.put("Msg","终端序列号已存在！");
        }
        ResponseUtil.response(response,jsonMap);
    }

    @RequestMapping("/check")
    public void check(HttpServletRequest request, HttpServletResponse response){
        Map jsonMap = new HashMap();
        String terminalNo = request.getParameter("TerminalNo");
        Terminal terminal = terminalService.getTerminalByNo(terminalNo);
        if(terminal != null && terminal.getPublishState() == 1){
            jsonMap.put("IsOk",true);
        }else {
            jsonMap.put("IsOk",false);
        }
        ResponseUtil.response(response,jsonMap);
    }
}
