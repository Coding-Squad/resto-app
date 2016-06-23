package com.reminisense.ra.controllers;

import com.reminisense.ra.entity.CompanyEntity;
import com.reminisense.ra.service.CompanyService;
import com.reminisense.ra.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Nigs on 2016-05-12.
 */
@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public String listCompanies(Model model) {
        model.addAttribute("company", new CompanyEntity());
        model.addAttribute("listCompany", this.companyService.listCompanies());
        return "company.jsp";
    }

    @RequestMapping(value = "/company/add", method = RequestMethod.POST)
    public String addCompany(@ModelAttribute("company") CompanyEntity c) {

        if (c.getCompanyId() == 0) {
            this.companyService.addCompany(c);
        } else {
            this.companyService.updateCompany(c);
        }

        return "redirect:/company";

    }

    @RequestMapping("/company/remove/{companyId}")
    public String removeCompany(@PathVariable("companyId") int companyId) {

        this.companyService.removeCompany(companyId);
        return "redirect:/company";
    }

    @RequestMapping("/company/edit/{companyId}")
    public String editCompany(@PathVariable("companyId") int id, Model model) {
        model.addAttribute("company", this.companyService.getCompanyById(id));
        model.addAttribute("listCompany", this.companyService.listCompanies());
        return "company.jsp";
    }

}
