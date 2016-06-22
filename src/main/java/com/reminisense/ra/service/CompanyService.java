package com.reminisense.ra.service;

import com.reminisense.ra.entity.CompanyEntity;

import java.util.List;

/**
 * Created by Nigs on 2016-05-12.
 */
public interface CompanyService {

    void addCompany(CompanyEntity p);

    void updateCompany(CompanyEntity p);

    List<CompanyEntity> listCompanies();

    CompanyEntity getCompanyById(int id);

    void removeCompany(int id);
}
