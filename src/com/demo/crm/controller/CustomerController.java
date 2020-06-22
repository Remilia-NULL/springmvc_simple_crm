package com.demo.crm.controller;

import com.demo.crm.pojo.BaseDict;
import com.demo.crm.pojo.Customer;
import com.demo.crm.service.BaseDictService;
import com.demo.crm.service.CustomerService;
import com.demo.crm.until.Constants;
import com.demo.crm.until.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    BaseDictService baseDictService;

    @GetMapping("/customer.html")
    public String customerPage(@RequestParam(defaultValue = "1") int page, Model model, Customer customer) {
        List<BaseDict> customerSource = baseDictService.selectDictByTypeCode(Constants.CUSTOMER_SOURCE_DICT_TYPE);
        List<BaseDict> customerIndustry = baseDictService.selectDictByTypeCode(Constants.CUSTOMER_INDSTRAY_DICT_TYPE);
        List<BaseDict> customerLevel = baseDictService.selectDictByTypeCode(Constants.CUSTOMER_LEVEL_DICT_TYPE);

        model.addAttribute("customerSource", customerSource);
        model.addAttribute("customerIndustry", customerIndustry);
        model.addAttribute("customerLevel", customerLevel);
        Paging<Customer> customerPaging = customerService.selectCustomer(page, 20, customer);
        model.addAttribute("customer", customerPaging);
        return "customer";
    }


}
