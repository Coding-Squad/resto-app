package com.reminisense.ra.dao;

import com.reminisense.ra.entity.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao
{
    private static final Logger logger = LoggerFactory
            .getLogger(CompanyDao.class);

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")


    private SessionFactory sessionFactory;


    public Company addCompany(Company c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        session.flush();

        logger.info("Company saved successfully, Company Details=" + c);
        return c;
    }

    public Company updateCompany(Company c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(c);
        session.flush();
        logger.info("Company updated successfully, Company Details=" + c);
        return c;
    }


    public List<Company> listCompanies() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Company> companyList = session.createQuery( "from Company").list();
        return companyList;
    }

    public List<Company> getCompaniesByName() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Company> p = session.createQuery( "select name from Company").list();
        return p;
    }


    public Company getCompanyById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Company p = (Company) session.get(Company.class, new Integer(id));

        logger.debug("Company loaded successfully, Company details=" + p);
        return p;
    }

    public void removeCompany(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Company p = (Company) session.load(Company.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.debug("Company deleted successfully, company details=" + p);
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }



}
