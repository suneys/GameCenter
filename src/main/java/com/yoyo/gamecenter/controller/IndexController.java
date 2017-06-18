package com.yoyo.gamecenter.controller;

import com.yoyo.gamecenter.model.User;
import com.yoyo.gamecenter.service.ResourceService;
import com.yoyo.gamecenter.service.TerminalService;
import com.yoyo.gamecenter.service.impl.ResourceServiceImpl;
import com.yoyo.gamecenter.service.impl.TerminalServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/5/14 0014.
 */
@Controller
public class IndexController {

    @Resource
    ResourceService resourceService;

    @Resource
    TerminalService terminalService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        Short userRole = user.getUserRole();
        model.addAttribute("userRole", userRole);
        if (user.getUserName() != null) {
            model.addAttribute("name", user.getUserName());
        } else {
            model.addAttribute("name", user.getUserEmail());
        }
        return "/Menu/index";
    }

    @RequestMapping("/home")
    public String home(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("programNum", resourceService.getResourceCount(user.getId(),null));
        model.addAttribute("terminalNum", terminalService.getTerminalCount(user.getId(),null));

        return "/Menu/home";
    }

    @RequestMapping("/menu/terminal")
    public String terminal(){
        return "/Menu/terminal";
    }

    @RequestMapping("/menu/resource")
    public String resource(){
        return "Menu/resource";
    }
}

