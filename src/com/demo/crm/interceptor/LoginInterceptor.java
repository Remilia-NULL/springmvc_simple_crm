package com.demo.crm.interceptor;

import com.demo.crm.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        if (url.indexOf("login.action") >= 0 || url.indexOf("login.html") >= 0 || url.indexOf("css") >= 0 || url.indexOf("js") >= 0 || url.indexOf("font") >= 0 || url.indexOf("images") >= 0) {
            return true;
        }
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        if (user != null) {
            return true;
        }
        response.sendRedirect("login.html");
        return false;
    }
}
