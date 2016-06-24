package com.reminisense.ra.dao;

import com.reminisense.ra.entity.CustomerEntity;

import java.util.List;

/**
 * Created by Yumi on 6/23/2016.
 */
public interface CustomerDao {

    CustomerEntity addCustomer(CustomerEntity c);

    CustomerEntity updateCustomer(CustomerEntity c);

    List<CustomerEntity> listCustomers();

    CustomerEntity getCustomerById(int id);

    void removeCustomer(int id);
}
