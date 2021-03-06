package com.demo.crm.controller;

import com.demo.crm.pojo.BaseDict;
import com.demo.crm.pojo.Customer;
import com.demo.crm.pojo.User;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    BaseDictService baseDictService;

    @GetMapping("/customer.html")
    public String customerPage(@RequestParam(defaultValue = "1") int page, Model model, Customer customer) {
        String custIndustry= customer.getCust_industry();
        String custLevel=customer.getCust_level();
        String custSource=customer.getCust_source();
        List<BaseDict> customerSource = baseDictService.selectDictByTypeCode(Constants.CUSTOMER_SOURCE_DICT_TYPE);
        List<BaseDict> customerIndustry = baseDictService.selectDictByTypeCode(Constants.CUSTOMER_INDSTRAY_DICT_TYPE);
        List<BaseDict> customerLevel = baseDictService.selectDictByTypeCode(Constants.CUSTOMER_LEVEL_DICT_TYPE);
        model.addAttribute("customerSource", customerSource);
        model.addAttribute("customerIndustry", customerIndustry);
        model.addAttribute("customerLevel", customerLevel);

        model.addAttribute("custIndustry",custIndustry);
        model.addAttribute("custLevel",custLevel);
        model.addAttribute("custSource",custSource);
        Paging<Customer> customerPaging = customerService.selectCustomer(page, 20, customer);
        model.addAttribute("customer", customerPaging);
        return "customer";
    }

    @RequestMapping("/create.action")
    @ResponseBody
    public String createCoustomerAction(Customer customer, HttpSession httpSession){
        User user= (User) httpSession.getAttribute("user");
        customer.setCust_create_id(user.getUser_id());
        customer.setCust_createtime(new Date());
        if (customerService.insertCustomer(customer)>0){
            return "OK";
        }
        return "FALSE";
    }

    @RequestMapping("/getCustomerById.action")
    @ResponseBody
    public Customer getCustomerByID(Integer id){
        return customerService.selectCustomerByID(id);
    }

    @RequestMapping("/update.action")
    @ResponseBody
    public String updateCustomer(Customer customer){
        if (customerService.updateCustomerByID(customer)>0){
            return "OK";
        }
        return "false";
    }

    @RequestMapping("/delete.action")
    @ResponseBody
    public String delectCustomerByID(Integer id){
        if (customerService.delectCustomerByID(id)>0){
            return "OK";
        }
        return "false";
    }
}
