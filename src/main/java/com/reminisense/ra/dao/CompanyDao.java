package com.reminisense.ra.dao;

import com.reminisense.ra.entity.CompanyEntity;

import java.util.List;

/**
 * Created by Nigs on 2016-05-11.
 */
public interface CompanyDao {
    CompanyEntity addCompany(CompanyEntity c);

    CompanyEntity updateCompany(CompanyEntity c);

    List<CompanyEntity> listCompanies();

    CompanyEntity getCompanyById(int id);

    void removeCompany(int id);
}
