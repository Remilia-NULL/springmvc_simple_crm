package com.demo.crm.service.impl;

import com.demo.crm.mapper.CustomerMapper;
import com.demo.crm.pojo.Customer;
import com.demo.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Customer> selectCustomer() {
        return customerMapper.selectCustomer();
    }
}
