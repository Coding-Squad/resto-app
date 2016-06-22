package com.reminisense.ra.dao;

import com.reminisense.ra.entity.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nigs on 2016-05-16.
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory
            .getLogger(UserDaoImpl.class);

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserEntity addUser(UserEntity p) {
        Session session = this.sessionFactory.getCurrentSession();
        // encrypt password
        p.setPassword(bCryptPasswordEncoder.encode(p.getPassword()));
        session.persist(p);
        session.flush();
        logger.info("User saved successfully, User Details=" + p);
        return p;
    }

    @Override
    public UserEntity updateUser(UserEntity p) {
        return p;
    }

    @Override
    public List<UserEntity> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserEntity> users = session.createQuery("from UserEntity").list();
        return users;
    }

    @Override
    public List<UserEntity> listUsersByCompanyId(int companyId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserEntity> users = session
                .createQuery("from UserEntity where companyId=:id")
                .setParameter("id", companyId).list();
        return users;
    }

    @Override
    public UserEntity getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity p = (UserEntity) session.get(UserEntity.class, new Integer(id));

        logger.debug("User loaded successfully, User details=" + p);
        return p;
    }

    @Override
    public void removeUser(int id) {

    }

    public UserEntity findByEmail(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(
                "from UserEntity where email = :email").setParameter("email", email);
        List<UserEntity> users = query.list();
        if (users == null || users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }
}
