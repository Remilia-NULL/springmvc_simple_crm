package com.demo.crm.mapper;

import com.demo.crm.pojo.Customer;

import java.util.List;

public interface CustomerMapper {
    public List<Customer> selectCustomer(Customer customer);

    public Integer insertCustomer(Customer customer);

    public Customer selectCustomerByID(Integer id);

    public Integer updateCustomerByID(Customer customer);

    public Integer delectCustomerByID(Integer id);
}
