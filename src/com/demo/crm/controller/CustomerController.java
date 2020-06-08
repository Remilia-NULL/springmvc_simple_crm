package com.demo.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @GetMapping("/customer.html")
    public String customerPage() {
        return "customer";
    }
}
