package com.reminisense.ra.dao;

import com.reminisense.ra.entity.Meal;

import java.util.List;


public interface MealDao
{
   Meal addMeal(Meal m);

    Meal updateMeal(Meal m);

    List<Meal> listMeals();

    List<Meal> listMealByCompanyId(int companyId);

    Meal getMealById(int id);

    void removeMeal(int id);



}
