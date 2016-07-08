package com.reminisense.ra.dao;

import com.reminisense.ra.entity.DishEntity;

import java.util.List;

/**
 * Created by Yumi on 7/7/2016.
 */
public interface DishDao {
    DishEntity addDish(DishEntity c);

    DishEntity updateDish(DishEntity c);

    List<DishEntity> listDishes();

    DishEntity getDishById(int id);

    void removeDish(int id);
}
