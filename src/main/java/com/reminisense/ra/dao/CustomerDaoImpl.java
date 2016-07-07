package com.reminisense.ra.dao;

import com.reminisense.ra.entity.CustomerEntity;
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
 * Created by Yumi on 6/23/2016.
 */

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao
{
    private static final Logger logger = LoggerFactory
            .getLogger(CustomerDao.class);

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")

    private SessionFactory sessionFactory;

    public CustomerEntity addCustomer(CustomerEntity c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        session.flush();
        logger.info("Customer saved successfully, Customer Details=" + c);
        return c;
    }

    public CustomerEntity updateCustomer(CustomerEntity c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(c);
        session.flush();
        logger.info("Customer updated successfully, Customer Details=" + c);
        return c;
    }

    public List<CustomerEntity> listCustomers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<CustomerEntity> customerEntityList = session.createQuery( "from CustomerEntity").list();
        return customerEntityList;
    }

    public CustomerEntity getCustomerById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CustomerEntity p = (CustomerEntity) session.get(CustomerEntity.class, new Integer(id));

        logger.debug("Customer loaded successfully, Customer details=" + p);
        return p;
    }

    public void removeCustomer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CustomerEntity p = (CustomerEntity) session.load(CustomerEntity.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.debug("Customer deleted successfully, customer details=" + p);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
