package com.reminisense.ra.service;

import com.reminisense.ra.dao.CustomerDao;
import com.reminisense.ra.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yumi on 6/23/2016.
 */

@Service
public class CustomerServiceImpl implements CustomerService
    {
        @Autowired
        private CustomerDao customerDao;

        @Override
        public void addCustomer(CustomerEntity p) {customerDao.addCustomer(p);
    }

        @Override
        public void updateCustomer(CustomerEntity p) {
        customerDao.updateCustomer(p);
    }

        @Override
        public List<CustomerEntity> listCustomers() {
        return customerDao.listCustomers();
    }

        @Override
        public CustomerEntity getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

        @Override
        public void removeCustomer(int id) {customerDao.removeCustomer(id);}

    }


