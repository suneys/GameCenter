package com.yoyo.gamecenter.controller;

import com.yoyo.gamecenter.model.User;
import com.yoyo.gamecenter.service.GameService;
import com.yoyo.gamecenter.service.ResourceService;
import com.yoyo.gamecenter.service.TerminalService;
import com.yoyo.gamecenter.service.impl.ResourceServiceImpl;
import com.yoyo.gamecenter.service.impl.TerminalServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/14 0014.
 */
@Controller
public class IndexController {

    @Resource
    ResourceService resourceService;

    @Resource
    TerminalService terminalService;

    @Resource
    GameService gameService;

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
        model.addAttribute("programNum", resourceService.getResourceCount(user.getId(), null));
        model.addAttribute("terminalNum", terminalService.getTerminalCount(user.getId(), null));
        model.addAttribute("gameNum",gameService.getGameCount(null));
        return "/Menu/home";
    }

    @RequestMapping("/menu/terminal")
    public String terminal(Model model) {
        model.addAttribute("disabled",1);
        return "/Menu/terminal";
    }

    @RequestMapping("/menu/resource")
    public String resource() {
        return "Menu/resource";
    }

    @RequestMapping("/menu/sendResource")
    public void sendResource(HttpServletRequest request, HttpServletResponse response) {
        try {
            String ids = request.getParameter("Ids");
            String type = request.getParameter("type");
            request.setAttribute("ids", ids);
            request.setAttribute("disabled",0);
            request.setAttribute("type",type);
            request.getRequestDispatcher("/WEB-INF/jsp/Menu/terminal.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/menu/game")
    public String game() {
        return "Menu/game";
    }
}

