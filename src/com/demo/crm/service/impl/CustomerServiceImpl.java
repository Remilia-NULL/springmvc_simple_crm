package com.demo.crm.service.impl;

import com.demo.crm.mapper.CustomerMapper;
import com.demo.crm.pojo.Customer;
import com.demo.crm.service.CustomerService;
import com.demo.crm.until.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Paging<Customer> selectCustomer(Integer page, Integer pagesize) {
        List<Customer> customers = customerMapper.selectCustomer();
        return new Paging<Customer>(customers, page, pagesize);
    }
}
