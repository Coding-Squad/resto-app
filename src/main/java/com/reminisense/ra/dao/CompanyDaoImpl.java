package com.reminisense.ra.dao;

import com.reminisense.ra.entity.CompanyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nigs on 2016-05-11.
 */
@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao {
    private static final Logger logger = LoggerFactory
            .getLogger(CompanyDao.class);

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public CompanyEntity addCompany(CompanyEntity c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        session.flush();
        logger.info("Company saved successfully, Company Details=" + c);
        return c;
    }

    public CompanyEntity updateCompany(CompanyEntity c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(c);
        session.flush();
        logger.info("Company updated successfully, Company Details=" + c);
        return c;
    }

    public List<CompanyEntity> listCompanies() {
        Session session = this.sessionFactory.getCurrentSession();
        List<CompanyEntity> companyEntityList = session.createQuery("from CompanyEntity").list();
        return companyEntityList;
    }

    public CompanyEntity getCompanyById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CompanyEntity p = (CompanyEntity) session.get(CompanyEntity.class, new Integer(id));

        logger.debug("Company loaded successfully, Company details=" + p);
        return p;
    }

    public void removeCompany(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CompanyEntity p = (CompanyEntity) session.load(CompanyEntity.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.debug("Company deleted successfully, company details=" + p);
    }
}
