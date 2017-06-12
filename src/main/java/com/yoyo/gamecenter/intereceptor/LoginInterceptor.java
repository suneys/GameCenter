package com.yoyo.gamecenter.intereceptor;

import com.yoyo.gamecenter.model.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/5/14 0014.
 */
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestUri = httpServletRequest.getRequestURI();
        if (requestUri.indexOf("login") > 0
                || requestUri.indexOf("register") > 0
                || requestUri.indexOf("getAuthCode") > 0
                || requestUri.indexOf("sendEmail") > 0
                || requestUri.indexOf("resetPassword") > 0
                ) {
            return true;
        } else {
            HttpSession session = httpServletRequest.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null) {
                return true;
            } else {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsp");
                return false;
            }
        }

    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
