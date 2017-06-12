package com.yoyo.gamecenter.controller;

import com.alibaba.fastjson.JSON;
import com.yoyo.gamecenter.model.User;
import com.yoyo.gamecenter.service.UserService;
import com.yoyo.gamecenter.utils.CheckUtil;
import com.yoyo.gamecenter.utils.InfoUtil;
import com.yoyo.gamecenter.utils.MD5Util;
import com.yoyo.gamecenter.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.SimpleFormatter;


/**
 * Created by Administrator on 2017/5/12 0012.
 */
@Controller
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Resource
    UserService userService;

    @RequestMapping("/register")
    public void register(HttpServletRequest request, HttpServletResponse response) {
        Map jsonMap = new HashMap();
        try {
            String userName = ((String) request.getParameter("UserName")).trim();
            String password = ((String) request.getParameter("PassWord")).trim();
            String strCheck = userName + "◆" + password;
            if(!CheckUtil.checkHtmlData(strCheck)){
                jsonMap.clear();
                jsonMap.put("IsOk",false);
                jsonMap.put("Msg", InfoUtil.GetMsgInfo(1047));
                logger.error("使用含特殊字符的关键字");
            }else if(!CheckUtil.checkSqlData(strCheck)){
                jsonMap.clear();
                jsonMap.put("IsOk",false);
                jsonMap.put("Msg", InfoUtil.GetMsgInfo(1048));
                logger.error("使用含特殊字符的关键字");
            }else{
                User user = userService.getUserByPhoneOrEmail(userName);
                if (user != null){//用名存在
                    jsonMap.clear();
                    jsonMap.put("IsOk",false);
                    jsonMap.put("Msg", InfoUtil.GetMsgInfo(1009));
                    logger.error("使用含SQL语句的关键字");
                }else{//用户名不存在
                    user = new User();
                    user.setUserName(userName);
                    user.setUserPwd(MD5Util.getMd5(password));
                    user.setCreateTime(new Date());
                    user.setDaySend(0);
                    user.setIsDelete((short) 0);
                    user.setIsEnable((short) 1);
                    user.setModifyTime(new Date());
                    user.setTotalSend(0);
                    if (userName.contains("@")){ //用户名是邮箱名
                        user.setUserEmail(userName);
                    }else{
                        user.setUserPhone(userName);
                    }
                    user.setUserRole((short) 0);
                    userService.addUser(user);
                    request.getSession().setAttribute("user",user);
                    jsonMap.clear();
                    jsonMap.put("IsOk",true);
                    jsonMap.put("Msg", InfoUtil.GetMsgInfo(1005));
                    logger.info("注册成功");
                }
            }
        } catch (Exception e) {
            jsonMap.clear();
            jsonMap.put("IsOk",false);
            jsonMap.put("Msg", InfoUtil.GetMsgInfo(1001));
            logger.info("注册失败");
        }finally {
            ResponseUtil.response(response,jsonMap);
        }
    }

    @RequestMapping("/login")
    public void login(HttpServletRequest request,HttpServletResponse response){
        Map jsonMap = new HashMap();
        try {
            String userName = request.getParameter("UserName");
            String password = request.getParameter("PassWord");
            User user = userService.getUserByPhoneOrEmail(userName);
            if(user == null){
                //用户不存在
                jsonMap.clear();
                jsonMap.put("IsOk",false);
                jsonMap.put("Msg", InfoUtil.GetMsgInfo(1075));
            }else{
                if(user.getIsDelete() == 1){
                    //用户被删除
                    jsonMap.clear();
                    jsonMap.put("IsOk",false);
                    jsonMap.put("Msg", InfoUtil.GetMsgInfo(1049));
                }else if(user.getIsEnable() == 0){
                    //用户被禁用
                    jsonMap.clear();
                    jsonMap.put("IsOk",false);
                    jsonMap.put("Msg", InfoUtil.GetMsgInfo(1045));
                }else{
                    if(MD5Util.getMd5(password).equals(user.getUserPwd())){
                        //登录成功
                        jsonMap.clear();
                        jsonMap.put("IsOk",true);
                        jsonMap.put("Msg", InfoUtil.GetMsgInfo(1015));
                        request.getSession().setAttribute("user",user);
                    }else{
                        //密码错误
                        jsonMap.clear();
                        jsonMap.put("IsOk",false);
                        jsonMap.put("Msg", InfoUtil.GetMsgInfo(1076));
                    }
                }
            }
        } catch (Exception e) {
            jsonMap.clear();
            jsonMap.put("IsOk",false);
            jsonMap.put("Msg", InfoUtil.GetMsgInfo(1001));
            logger.error(e);
        } finally {
            ResponseUtil.response(response,jsonMap);
        }
    }

    @SuppressWarnings("Since15")
    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request){
        ModelAndView model = new ModelAndView("public");
        String msg = "";
        try {
            String userID = request.getParameter("userID");
            String password = request.getParameter("password");

            if(userID == null || password == null || userID.isEmpty() || password.isEmpty())
            {
                msg = "修改密码失败，请稍后再试！";
                model.addObject("msg",msg);
                return model;
            }
            User user = userService.getUserById(Long.parseLong(userID));
            user.setUserPwd(MD5Util.getMd5(password));
            userService.updateUser(user);
            msg = "修改密码成功，<a href=\""+request.getContextPath()+"/login.jsp\">请重新登录</a>";
            model.addObject("msg",msg);
            return model;
        } catch (Exception e) {
            msg = "修改密码失败，请稍后再试！";
            model.addObject("msg",msg);
            return model;
        }
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request,HttpServletResponse response) throws Exception {
        request.getSession().removeAttribute("user");
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }
}
