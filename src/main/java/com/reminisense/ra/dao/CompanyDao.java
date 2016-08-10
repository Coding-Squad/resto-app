package com.reminisense.ra.dao;

import com.reminisense.ra.entity.Company;

import java.util.List;


public interface CompanyDao
{
    Company addCompany (Company c);

    Company updateCompany(Company c);

    List<Company> listCompanies();

    List<Company> getCompaniesByName();

    Company getCompanyById(int id);

    void removeCompany(int id);


}

