package com.reminisense.ra.dto.factory;

import com.reminisense.ra.dto.json.MealDto;
import com.reminisense.ra.entity.Company;
import com.reminisense.ra.entity.Meal;

/**
 * Created by Yumi on 7/14/2016.
 */
public final class MealFactory
{

    public static MealDto createMealDto(Meal meal) {
        if (meal == null) return null;
        Integer companyId = meal.getCompany() == null ? null : meal.getCompany().getCompanyId();

        return new MealDto(
               meal.getMealId(),
                companyId,
               meal.getName(),
               meal.getDescription(),
               meal.getPrice(),
               meal.getQuantity()
       );
    }
    public static Meal createMeal(MealDto p, Company company) {
        Meal m = new Meal();
        m.setMealId(p.getMealId());
        m.setCompany(company);
        m.setName(p.getName());
        m.setDescription(p.getDescription());
        m.setPrice(p.getPrice());
        m.setQuantity(p.getQuantity());
        return m;

    }
}
