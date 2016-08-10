package com.reminisense.ra.service;

import com.reminisense.ra.dto.json.MealDto;
import com.reminisense.ra.entity.Meal;
import com.reminisense.ra.exception.RegistrationException;

import java.util.List;

/**
 * Created by Yumi on 7/12/2016.
 */
public interface MealService {

    MealDto addMeal(MealDto m) throws RegistrationException;
    List<MealDto> listMeals();
    List<MealDto> listMealByCompany(int companyId);
    MealDto updateMeal(MealDto m) throws RegistrationException;
    Meal getMealById(int id);
    void removeMeal(int id);
}

