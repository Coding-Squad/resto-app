package com.reminisense.ra.controllers;

import com.reminisense.ra.entity.Company;
import com.reminisense.ra.exception.CompanyNotFoundException;
import com.reminisense.ra.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Yumi on 7/12/2016.
 */
@Controller
public class CompanyController
{
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public String company(Model model) {
        model.addAttribute("company", new Company());
        model.addAttribute("listCompany", this.companyService.listCompanies());
        return "company.jsp";
    }


    @RequestMapping(value = "/company/add", method = RequestMethod.POST)
    public String addCompany(@ModelAttribute("company") Company c) {

        if (c.getCompanyId() == 0) {
            this.companyService.addCompany(c);
        } else {
            this.companyService.updateCompany(c);
        }

        return "redirect:/company";
    }

    @RequestMapping("/company/edit/{companyId}")
    public String editCompany(@PathVariable("companyId") int companyId, Model model) throws CompanyNotFoundException {

        Company company = this.companyService.getCompanyById(companyId);
        if (company == null) {
            throw new CompanyNotFoundException();
        }
        model.addAttribute("company", company);
        model.addAttribute("listCompany", this.companyService.listCompanies());
        return "company.jsp";
    }

    @RequestMapping("/company/remove/{companyId}")
    public String removeCompany(@PathVariable("companyId") int companyId) {

        this.companyService.removeCompany(companyId);
        return "redirect:/company";
    }


}
