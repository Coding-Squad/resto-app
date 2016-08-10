package com.reminisense.ra.service;

import com.reminisense.ra.entity.Company;

import java.util.List;

public interface CompanyService
{
    void addCompany(Company c);

    void updateCompany(Company c);

    List<Company> listCompanies();

    List<Company> getCompaniesByName();

    Company getCompanyById(int id);

    void removeCompany(int id);


}
