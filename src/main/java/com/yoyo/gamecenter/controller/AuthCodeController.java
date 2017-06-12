package com.yoyo.gamecenter.controller;

import com.yoyo.gamecenter.model.User;
import com.yoyo.gamecenter.service.UserService;
import com.yoyo.gamecenter.utils.InfoUtil;
import com.yoyo.gamecenter.utils.MD5Util;
import com.yoyo.gamecenter.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.Authenticator;
import java.util.*;

/**
 * Created by Administrator on 2017/5/12 0012.
 * 获取验证码控制器
 */
@Controller
public class AuthCodeController {

    @Resource
    UserService userService;


    @RequestMapping("/getAuthCode")
    public void getAuthCode(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws IOException {
        int width = 72;
        int height = 45;
        Random random = new Random();
        //设置response头信息
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //生成缓冲区image类
        BufferedImage image = new BufferedImage(width, height, 1);
        //产生image类的Graphics用于绘制操作
        Graphics g = image.getGraphics();
        //Graphics类的样式
        g.setColor(this.getRandColor(200, 250));
        g.setFont(new Font("Times New Roman",0,28));
        g.fillRect(0, 0, width, height);
        //绘制干扰线
        for(int i=0;i<40;i++){
            g.setColor(this.getRandColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }

        //绘制字符
        String strCode = "";
        for(int i=0;i<4;i++){
            String rand = String.valueOf(random.nextInt(10));
            strCode = strCode + rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand, 13*i+6, 28);
        }
        //将字符保存到session中用于前端的验证
        session.setAttribute("strCode", strCode);
        g.dispose();

        ImageIO.write(image, "JPEG", response.getOutputStream());
        response.getOutputStream().flush();

    }

    //创建颜色
    Color getRandColor(int fc,int bc){
        Random random = new Random();
        if(fc>255)
            fc = 255;
        if(bc>255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
    }

    @RequestMapping("/resetPassword")
    public ModelAndView resetPassword(HttpServletRequest request, HttpServletResponse response){
        ModelAndView model = new ModelAndView("public");
        String sid = request.getParameter("sid");
        String id = request.getParameter("id");
        String msg = "";
        if(sid.equals("") || id.equals("")){
            msg="链接不完整,请重新生成";
            model.addObject("msg",msg) ;
            return model;
        }
        Long uId = Long.parseLong(id);
        User user = userService.getUserById(uId);
        if(user == null){
            msg = "链接错误,无法找到匹配用户,请重新申请找回密码.";
            model.addObject("msg",msg) ;
            return model;
        }
        Long outDate = user.getUserOutDate();
        if(outDate <= System.currentTimeMillis()) {         //表示已经过期
            msg = "链接已经过期,请重新申请找回密码.";
            model.addObject("msg", msg);
            return model;
        }
        String key =user.getUserName() + "$" + outDate + "$" + user.getUserSecretKey();
        String digitalSignature = MD5Util.getMd5(key);
        if(!digitalSignature.equals(sid)) {
            msg = "链接不正确,是否已经过期了?重新申请吧";
            model.addObject("msg",msg) ;
            return model;
        }
        request.getSession().setAttribute("user",user);
        model.setViewName("resetPassword");  //返回到修改密码的界面
        model.addObject("userId",id);
        return model;
    }

    @RequestMapping("/sendEmail")
    public void sendEamil(HttpServletRequest request,HttpServletResponse response){
        Map jsonMap = new HashMap();
        try {
            String userName = request.getParameter("SendName");
            String userEmail = request.getParameter("SendEmail");
            String code = request.getParameter("code");
            String strCode = (String) request.getSession().getAttribute("strCode");
            if(strCode.equals(code)){
                //验证码正确
                User user = userService.getUserByName(userName);
                if(user == null){
                    jsonMap.clear();
                    jsonMap.put("IsOk",false);
                    jsonMap.put("Msg", InfoUtil.GetMsgInfo(1075));
                }else{
                    Properties prop = new Properties();
                    prop.setProperty("mail.transport.protocol", "smtp");
                    prop.setProperty("mail.smtp.host", "smtp.qq.com");
                    prop.setProperty("mail.smtp.auth", "true");
                    prop.put("mail.smtp.port","587");
                    Session session = Session.getDefaultInstance(prop);
                    session.setDebug(true);
                    //创建邮件
                    MimeMessage message = new MimeMessage(session);
                    //设置发件人
                    message.setFrom(new InternetAddress("449222861@qq.com"));
                    //设置收件人
                    message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(userEmail));
                    //设置主题
                    message.setSubject("找回密码");
                    //设置邮件正文
                    message.setContent(createLink(user,request),"text/html;charset=UTF-8");
                    //设置发件时间
                    message.setSentDate(new Date());
                    //保存设置
                    message.saveChanges();

                    //获取邮件传输对象
                    Transport transport = session.getTransport();

                    transport.connect("449222861@qq.com","laexnpqudwszbidj");

                    transport.sendMessage(message,message.getAllRecipients());

                    transport.close();

                    jsonMap.clear();
                    jsonMap.put("IsOk",true);
                    jsonMap.put("Msg", InfoUtil.GetMsgInfo(1075));
                }
            }else{
                jsonMap.clear();
                jsonMap.put("IsOk",false);
                jsonMap.put("Msg", InfoUtil.GetMsgInfo(1102));
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonMap.clear();
            jsonMap.put("IsOk",false);
            jsonMap.put("Msg", InfoUtil.GetMsgInfo(1001));
        } finally {
            ResponseUtil.response(response,jsonMap);
        }
    }

    public String createLink(User user,HttpServletRequest request){

        //生成密钥
        String secretKey= UUID.randomUUID().toString();
        //设置过期时间
        Date outDate = new Date(System.currentTimeMillis() + 30 * 60 * 1000);// 30分钟后过期
        System.out.println(System.currentTimeMillis());
        long date = outDate.getTime() / 1000 * 1000;// 忽略毫秒数  mySql 取出时间是忽略毫秒数的

        //此处应该更新Studentinfo表中的过期时间、密钥信息
        user.setUserOutDate(date);
        user.setUserSecretKey(secretKey);
        userService.updateUser(user);
        //将用户名、过期时间、密钥生成链接密钥
        String key =user.getUserName() + "$" + date + "$" + secretKey;

        String digitalSignature = MD5Util.getMd5(key);// 数字签名

        String path=request.getContextPath();

        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

        String resetPassHref = basePath + "/resetPassword?sid="+ digitalSignature +"&id="+user.getId();

        String emailContent = "请勿回复本邮件.点击下面的链接,重设密码,本邮件超过30分钟,链接将会失效，需要重新申请找回密码." + resetPassHref;

        return emailContent;
    }
}
