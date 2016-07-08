package com.reminisense.ra.service;

import com.reminisense.ra.dao.DishDao;
import com.reminisense.ra.entity.DishEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yumi on 7/7/2016.
 */
@Service("dishService")
public class DishServiceImpl implements DishService {
        @Autowired
        private DishDao dishDao;

        @Override
        public void addDish(DishEntity p) {dishDao.addDish(p);
        }

        @Override
        public void updateDish(DishEntity p) {
            dishDao.updateDish(p);
        }

        @Override
        public List<DishEntity> listDishes() {

            return dishDao.listDishes();
        }

        @Override
        public DishEntity getDishById(int id) {

                return dishDao.getDishById(id);
        }

        @Override
        public void removeDish(int id) {dishDao.removeDish(id);}
}
