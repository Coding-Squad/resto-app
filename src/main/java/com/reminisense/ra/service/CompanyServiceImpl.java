package com.reminisense.ra.service;

import com.reminisense.ra.dao.CompanyDao;
import com.reminisense.ra.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yumi on 7/12/2016.
 */
@Service
public class CompanyServiceImpl implements CompanyService
{
   @Autowired
   private CompanyDao companyDao;

    @Override
    public void addCompany(Company c) {companyDao.addCompany(c);}

    @Override
    public void updateCompany(Company c) {companyDao.updateCompany(c);}

    @Override
    public List<Company> listCompanies()  {
        return companyDao.listCompanies();
    }

    @Override
    public  List<Company> getCompaniesByName() { return companyDao.getCompaniesByName();}

    @Override
    public Company getCompanyById(int id)  {
        return companyDao.getCompanyById(id);
    }

    @Override
    public void removeCompany(int id)  {companyDao.removeCompany(id);}
}
