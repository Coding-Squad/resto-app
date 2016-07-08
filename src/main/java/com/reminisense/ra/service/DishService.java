package com.reminisense.ra.service;

import com.reminisense.ra.entity.DishEntity;

import java.util.List;

/**
 * Created by Yumi on 7/7/2016.
 */
public interface DishService {
    void addDish(DishEntity p);

    void updateDish(DishEntity p);

    List<DishEntity> listDishes();

    DishEntity getDishById(int id);

    void removeDish(int id);
}
