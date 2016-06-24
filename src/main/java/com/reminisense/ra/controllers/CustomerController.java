package com.reminisense.ra.controllers;

import com.reminisense.ra.entity.CustomerEntity;
import com.reminisense.ra.exception.CustomerNotFoundException;
import com.reminisense.ra.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Yumi on 6/23/2016.
 */

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String listCustomers(Model model) {
        model.addAttribute("customer", new CustomerEntity());
        model.addAttribute("listCustomer", this.customerService.listCustomers());
        return "customer.jsp";
    }

    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") CustomerEntity c) {

        if (c.getCustomerId() == 0) {
            this.customerService.addCustomer(c);
        } else {
            this.customerService.updateCustomer(c);
        }

        return "redirect:/customer";

    }


    @RequestMapping("/customer/edit/{customerId}")
    public String editCustomer(@PathVariable("customerId") int customerId, Model model) throws CustomerNotFoundException {

        CustomerEntity customer = this.customerService.getCustomerById(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }
        model.addAttribute("customer", customer);
        model.addAttribute("listCustomer", this.customerService.listCustomers());
        return "customer.jsp";
    }


    @RequestMapping("/customer/remove/{customerId}")
    public String removeCustomer(@PathVariable("customerId") int customerId) {

        this.customerService.removeCustomer(customerId);
        return "redirect:/customer";
    }
}
