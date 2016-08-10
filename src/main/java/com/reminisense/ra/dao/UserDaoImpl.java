package com.reminisense.ra.dao;

import com.reminisense.ra.dto.json.UserDto;
import com.reminisense.ra.entity.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yumi on 7/7/2016.
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory
            .getLogger(UserDaoImpl.class);

    @Value("${superadmin.user}")
    private String admin;

    @Value("${superadmin.pass}")
    private String pass;

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


    @Override
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

    public UserEntity findByEmail(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(
                "from UserEntity where email = :email").setParameter("email", email);
        List<UserEntity> users = query.list();
        if (users == null || users.isEmpty()) {
            // in-memory user
            if (email.equals(admin)) {
                UserEntity user = new UserEntity();
                user.setEmail(admin);
                user.setPassword(pass);
                user.setAuthorities("ROLE_USER");
                user.setFirstName("SUPER ADMIN");
                user.setLastName("SUPER ADMIN");
//

                users = new ArrayList<>();
                users.add(user);
            }
        }
        return users != null && !users.isEmpty() ? users.get(0) : null;
    }




}

