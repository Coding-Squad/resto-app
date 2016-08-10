package com.reminisense.ra.service;

import com.reminisense.ra.dao.MealDao;
import com.reminisense.ra.dao.PromoDao;
import com.reminisense.ra.dto.json.PromoDto;
import com.reminisense.ra.dto.factory.PromoFactory;
import com.reminisense.ra.entity.Meal;
import com.reminisense.ra.entity.Promo;
import com.reminisense.ra.exception.RegistrationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rubyline on 8/2/2016.
 */
@Service
public class PromoServiceImpl implements PromoService{

    private static final Logger logger = LoggerFactory
            .getLogger(PromoService.class);

    @Autowired
    MealDao mealDao;

    @Autowired
    PromoDao promoDao;

    @Override
    public PromoDto addMeal(PromoDto p) throws RegistrationException {
        Meal meal = mealDao.getMealById(p.getMealId());
        if (meal == null) {
            throw new RegistrationException("Company does not exist.");
        }

        return  PromoFactory.createPromoDto(
                promoDao.addPromo(PromoFactory.createPromo(p, meal)));

    }


    @Override
    public List<PromoDto> listPromos() {
            List<PromoDto> p = new ArrayList<PromoDto>();
            List<Promo> promos= promoDao.listPromos();
            for (Promo promo : promos) {
                p.add(PromoFactory.createPromoDto(promo));
            }
            return p;
    }

    @Override
    public List<PromoDto> listPromoByMeal(int mealId) {
        List<PromoDto> m = new ArrayList<PromoDto>();
        List<Promo> promos = promoDao.listPromoByMealId(mealId);
        for (Promo promo : promos) {
            m.add(PromoFactory.createPromoDto(promo));
        }
        return m;
    }

    @Override
    public PromoDto updatePromo(PromoDto p) throws RegistrationException {
        Meal meal = mealDao.getMealById(p.getMealId());
        if ( meal == null) {
            throw new RegistrationException("Meal does not exist.");
        }
        return PromoFactory.createPromoDto(
                promoDao.updatePromo(PromoFactory.createPromo(p, meal)));
    }

    @Override
    public Promo getPromoById(int id) {{return promoDao.getPromoById(id);}
    }

    @Override
    public void removePromo(int id) {{promoDao.removePromo(id);
        }
    }
}
