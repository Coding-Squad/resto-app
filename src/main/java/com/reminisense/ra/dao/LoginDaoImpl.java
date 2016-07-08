package com.reminisense.ra.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yumi on 7/5/2016.
 */
@Repository("loginDao")
public class LoginDaoImpl implements  LoginDao{
    @Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }

    public boolean checkLogin(String username, String password){
        System.out.println("In Check login");
        Session session = sessionFactory.openSession();
        boolean userFound = false;
        //Query using Hibernate Query Language
        String SQL_QUERY =" from UserEntity as o where o.username=? and o.password=?";
        Query query = session.createQuery(SQL_QUERY);
        query.setParameter(0,username);
        query.setParameter(1,password);
        List list = query.list();

        if ((list != null) && (list.size() > 0)) {
            userFound= true;
        }

        session.close();
        return userFound;
    }
}
