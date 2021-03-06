package com.demo.crm.service;

import com.demo.crm.pojo.Customer;
import com.demo.crm.until.Paging;

import java.util.List;

public interface CustomerService {
    public Paging<Customer> selectCustomer(Integer page, Integer pagesize,Customer customer);
    public Integer insertCustomer(Customer customer);
    public Customer selectCustomerByID(Integer id);
    public Integer updateCustomerByID(Customer customer);
    public Integer delectCustomerByID(Integer id);
}
