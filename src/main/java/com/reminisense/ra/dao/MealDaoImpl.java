package com.reminisense.ra.dao;

import com.reminisense.ra.entity.Meal;
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
 * Created by Yumi on 7/12/2016.
 */
@Repository
@Transactional
public class MealDaoImpl implements MealDao
{
    private static final Logger logger = LoggerFactory
            .getLogger(MealDaoImpl.class);

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public Meal addMeal(Meal m) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(m);
        session.flush();
        logger.info("Meal saved successfully, Meal Details=" + m);
        return m;
    }


    @Override
    public Meal updateMeal(Meal m) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(m);
        logger.info("Meal updated successfully, Meal Details=" + m);
        return m;
    }

    @Override
    public List<Meal> listMeals() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Meal> meals = session.createQuery( "from Meal").list();
        return meals;
    }


    @Override
    public List<Meal> listMealByCompanyId(int companyId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Meal> meals = session
                .createQuery("from Meal where companyId=:id")
                .setParameter("id", companyId).list();
        return meals;
    }


    public Meal getMealById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Meal m = (Meal) session.get(Meal.class, new Integer(id));

        logger.debug("Meal loaded successfully, Meal details=" + m);
        return m;
    }

    public void removeMeal(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Meal m = (Meal) session.load(Meal.class, new Integer(id));
        if (null != m) {
            session.delete(m);
        }
        logger.debug("Meal deleted successfully, meal details=" + m);
    }

}
