package com.demo.crm.controller;

import com.demo.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer.html")
    public String customerPage(@RequestParam(defaultValue = "1") int page , Model model) {
        model.addAttribute("customer",customerService.selectCustomer(page,20));
        return "customer";
    }
}
