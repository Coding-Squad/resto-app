package com.reminisense.ra.service;

import com.reminisense.ra.dao.CompanyDao;
import com.reminisense.ra.entity.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nigs on 2016-05-12.
 */
@Service
public class CompanyServiceImpl implements CompanyService {


    @Autowired
    private CompanyDao companyDao;

    @Override
    public void addCompany(CompanyEntity p) {
        companyDao.addCompany(p);
    }

    @Override
    public void updateCompany(CompanyEntity p) {
        companyDao.updateCompany(p);
    }

    @Override
    public List<CompanyEntity> listCompanies() {
        return companyDao.listCompanies();
    }

    @Override
    public CompanyEntity getCompanyById(int id) {
        return companyDao.getCompanyById(id);
    }

    @Override
    public void removeCompany(int id) {
        companyDao.removeCompany(id);
    }
}
