package com.yoyo.gamecenter.controller;

import com.yoyo.gamecenter.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/5/14 0014.
 */
@Controller
public class IndexController {

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

        model.addAttribute("programNum", user.getResources() == null ? 0 : user.getResources().size());
        model.addAttribute("terminalNum", user.getTerminals() == null ? 0 : user.getTerminals().size());

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

