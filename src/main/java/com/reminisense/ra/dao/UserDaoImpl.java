package com.reminisense.ra.dao;

import com.reminisense.ra.entity.UserEntity;
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
 * Created by Yumi on 7/7/2016.
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory
            .getLogger(UserDao.class);

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")


    private SessionFactory sessionFactory;

    public UserEntity addUser(UserEntity c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        session.flush();
        logger.info("User saved successfully, User Details=" + c);
        return c;
    }

    public UserEntity updateUser(UserEntity c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(c);
        session.flush();
        logger.info("User updated successfully, User Details=" + c);
        return c;
    }

    public List<UserEntity> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserEntity> customerEntityList = session.createQuery( "from UserEntity").list();
        return customerEntityList;
    }

    public UserEntity getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity p = (UserEntity) session.get(UserEntity.class, new Integer(id));

        logger.debug("User loaded successfully, User details=" + p);
        return p;
    }

    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity p = (UserEntity) session.load(UserEntity.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.debug("User deleted successfully, customer details=" + p);
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
