package com.reminisense.ra.service;

import com.reminisense.ra.entity.CustomerEntity;

import java.util.List;

/**
 * Created by Yumi on 6/23/2016.
 */
public interface CustomerService
{
    void addCustomer(CustomerEntity p);

    void updateCustomer(CustomerEntity p);

    List<CustomerEntity> listCustomers();

    CustomerEntity getCustomerById(int id);

    void removeCustomer(int id);
}
