package com.reminisense.ra.dto.factory;

import com.reminisense.ra.dto.json.PromoDto;
import com.reminisense.ra.entity.Meal;
import com.reminisense.ra.entity.Promo;

/**
 * Created by Rubyline on 8/2/2016.
 */
public final class PromoFactory {
public static PromoDto createPromoDto(Promo promo) {
        if (promo == null) return null;
        Integer mealId = promo.getMeal() == null ? null : promo.getMeal().getMealId();

        return new PromoDto(
        promo.getPromoId(),
        mealId,
        promo.getName(),
        promo.getDescription(),
        promo.getDiscount(),
        promo.getQuantity()
        );
        }
    public static Promo createPromo(PromoDto pp, Meal meal) {
        Promo p = new Promo();
        p.setPromoId(pp.getPromoId());
        p.setMeal(meal);
        p.setName(pp.getName());
        p.setDescription(pp.getDescription());
        p.setDiscount(pp.getDiscount());
        p.setQuantity(pp.getQuantity());
        return p;

        }
}
