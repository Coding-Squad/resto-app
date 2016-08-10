package com.reminisense.ra.controllers;

import com.reminisense.ra.dto.json.PromoDto;
import com.reminisense.ra.entity.Meal;
import com.reminisense.ra.exception.RegistrationException;
import com.reminisense.ra.service.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Rubyline on 8/2/2016.
 */
@Controller
public class PromoController {
    @Autowired
    PromoService promoService;

    @RequestMapping(value = "/promo", method = RequestMethod.GET)
    public String listPromos( Model model)
    {
        model.addAttribute("promo", new Meal());
        model.addAttribute("listPromo", this.promoService.listPromos());
        return "promo.jsp";
    }

    @RequestMapping(value = "/promo/add", method = RequestMethod.POST)
    public String addPromo(@ModelAttribute("promo") PromoDto u) throws RegistrationException {

        if (u.getPromoId() == 0 ) {
            this.promoService.addMeal(u);
        } else {
            this.promoService.updatePromo(u);
        }
        return "redirect:/promo";

    }



}
