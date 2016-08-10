package com.reminisense.ra.dao;

import com.reminisense.ra.entity.Promo;

import java.util.List;

/**
 * Created by Rubyline on 8/2/2016.
 */
public interface PromoDao {
    Promo addPromo(Promo p);

    Promo updatePromo(Promo p);

    List<Promo> listPromos();

    List<Promo> listPromoByMealId(int mealId);

    Promo getPromoById(int id);

    void removePromo(int id);
}
