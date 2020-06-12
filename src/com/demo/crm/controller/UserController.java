package com.demo.crm.controller;

import com.demo.crm.pojo.User;
import com.demo.crm.service.UserService;
import com.demo.crm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String indexPage(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        if (user != null) {
            return "redirect:customer.html";
        } else {
            return "redirect:login.html";
        }
    }

    @GetMapping("/login.html")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login.action")
    public String loginCheck(String usercode, String password, Model model, HttpSession httpSession) {
        User user = userService.checkUser(usercode, password);
        if (user == null) {
            model.addAttribute("msg", "用户名或者密码错误");
            return "login";
        }
        httpSession.setAttribute("user", user);
        return "redirect:customer.html";
    }
}
