package com.reminisense.ra.service;

import com.reminisense.ra.dto.json.PromoDto;
import com.reminisense.ra.entity.Promo;
import com.reminisense.ra.exception.RegistrationException;

import java.util.List;

/**
 * Created by Rubyline on 8/2/2016.
 */
public interface PromoService {
    PromoDto addMeal(PromoDto p) throws RegistrationException;
    List<PromoDto> listPromos();
    List<PromoDto> listPromoByMeal(int mealId);
    PromoDto updatePromo(PromoDto p) throws RegistrationException;
    Promo getPromoById(int id);
    void removePromo(int id);
}
