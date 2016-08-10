package com.reminisense.ra.dao;

import com.reminisense.ra.entity.Promo;
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
 * Created by Rubyline on 8/2/2016.
 */

@Repository
@Transactional
public class PromoDaoImpl implements PromoDao {
    private static final Logger logger = LoggerFactory
            .getLogger(PromoDaoImpl.class);

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;


    @Override
    public Promo addPromo(Promo p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        session.flush();
        logger.info("Promo saved successfully, Promo Details=" + p);
        return p;
    }

    @Override
    public Promo updatePromo(Promo p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Promo updated successfully, Promo Details=" + p);
        return p;
    }

    @Override
    public List<Promo> listPromos() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Promo> promos = session.createQuery( "from Promo").list();
        return promos;
    }

    @Override
    public List<Promo> listPromoByMealId(int mealId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Promo> promos= session
                .createQuery("from Promo where mealId=:id")
                .setParameter("id", mealId).list();
        return promos;
    }

    @Override
    public Promo getPromoById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Promo p = (Promo) session.get(Promo.class, new Integer(id));

        logger.debug("Promo loaded successfully, Promo details=" + p);
        return p;
    }

    @Override
    public void removePromo(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Promo p = (Promo) session.load(Promo.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.debug("Promo deleted successfully, promo details=" + p);
    }
}
