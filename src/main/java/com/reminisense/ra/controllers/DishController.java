package com.reminisense.ra.controllers;

import com.reminisense.ra.entity.DishEntity;
import com.reminisense.ra.exception.DishNotFoundException;
import com.reminisense.ra.service.LoginService;
import com.reminisense.ra.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Yumi on 7/7/2016.
 */
@Controller
public class DishController {

    @Autowired
    private DishService dishService;

    @RequestMapping(value = "/dish", method = RequestMethod.GET)
    public String dishes(Model model) {
        model.addAttribute("dish", new DishEntity());
        model.addAttribute("listDish", this.dishService.listDishes());
        return "dish";
    }

    @RequestMapping(value = "/dish/list", method = RequestMethod.GET)
    public String listDishes(Model model) {
        model.addAttribute("dish", new DishEntity());
        model.addAttribute("listDish", this.dishService.listDishes());
        return "dishInfo";
    }





    @RequestMapping(value = "/dish/add", method = RequestMethod.POST)
    public String addDish(@ModelAttribute("dish") DishEntity c) {

        if (c.getDishId() == 0) {
            this.dishService.addDish(c);
        } else {
            this.dishService.updateDish(c);
        }

        return "redirect:/dish";

    }


    @RequestMapping("/dish/edit/{dishId}")
    public String editDish(@PathVariable("dishId") int dishId, Model model) throws DishNotFoundException {

        DishEntity dish = this.dishService.getDishById(dishId);
        if (dish == null) {
            throw new DishNotFoundException();
        }
        model.addAttribute("dish", dish);
        model.addAttribute("listDish", this.dishService.listDishes());
        return "dish";
    }


    @RequestMapping("/dish/remove/{dishId}")
    public String removeDish(@PathVariable("dishId") int dishId) {

        this.dishService.removeDish(dishId);
        return "redirect:/dish";
    }
}
