package com.demo.crm.controller;

import com.demo.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer.html")
    public String customerPage(Model model) {
        model.addAttribute("customer",customerService.selectCustomer());
        return "customer";
    }
}
