package com.reminisense.ra.dao;

import com.reminisense.ra.entity.DishEntity;
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
public class DishDaoImpl implements DishDao {
    private static final Logger logger = LoggerFactory
            .getLogger(DishDao.class);

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")


    private SessionFactory sessionFactory;

    public DishEntity addDish(DishEntity c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        session.flush();
        logger.info("Dish saved successfully, Dish Details=" + c);
        return c;
    }

    public DishEntity updateDish(DishEntity c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(c);
        session.flush();
        logger.info("Dish updated successfully, Dish Details=" + c);
        return c;
    }

    public List<DishEntity> listDishes() {
        Session session = this.sessionFactory.getCurrentSession();
        List<DishEntity> dishEntityList = session.createQuery( "from DishEntity").list();
        return dishEntityList;
    }

    public DishEntity getDishById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        DishEntity p = (DishEntity) session.get(DishEntity.class, new Integer(id));

        logger.debug("Dish loaded successfully, Dish details=" + p);
        return p;
    }

    public void removeDish(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        DishEntity p = (DishEntity) session.load(DishEntity.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.debug("Dish deleted successfully, customer details=" + p);
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
