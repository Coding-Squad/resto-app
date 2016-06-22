package com.reminisense.ra.dao;

import com.reminisense.ra.entity.TransactionEntity;
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
 * Created by Nigs on 2016-05-17.
 */
@Repository
@Transactional
public class TransactionDaoImpl implements TransactionDao {
    private static final Logger logger = LoggerFactory
            .getLogger(TransactionDaoImpl.class);

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public TransactionEntity addTransaction(TransactionEntity c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        session.flush();
        logger.info("Transaction saved successfully, Transaction Details=" + c);
        return c;
    }

    @Override
    public List<TransactionEntity> listTransactions() {
        Session session = this.sessionFactory.getCurrentSession();
        List<TransactionEntity> tList = session.createQuery("from TransactionEntity").list();
        return tList;
    }
}
