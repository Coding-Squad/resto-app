package com.reminisense.ra.controllers;

import com.reminisense.ra.dto.json.MealDto;
import com.reminisense.ra.entity.Company;
import com.reminisense.ra.entity.Meal;
import com.reminisense.ra.exception.RegistrationException;
import com.reminisense.ra.service.CompanyService;
import com.reminisense.ra.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;


@Controller
public class MealController {
    @Autowired
    private MealService mealService;
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/meal", method = RequestMethod.GET)
    public String listMeals(Map<String, Object> map, Model model)
    {
        List<Company> companies = companyService.getCompaniesByName();
        System.out.println(companies);
        map.put("companyListName", companies);
        map.put("companies", new Company());
        model.addAttribute("company", new Company());
        model.addAttribute("companyListName", this.companyService.getCompaniesByName());
        model.addAttribute("meal", new Meal());
        model.addAttribute("listMeal", this.mealService.listMeals());
        return "meal.jsp";
    }



    @RequestMapping(value = "/meal/add{company}", method = RequestMethod.POST)
    public String addMeal(@ModelAttribute("meal") MealDto u) throws RegistrationException {
        System.out.println("HEREHERE: " + u.getName() + " | " + u.getCompanyId());
        System.out.println("MEEE: " + u.getCompanyId());

        if (u.getMealId() == 0 &&  u.getCompanyId() == 0) {
            this.mealService.addMeal(u);
        } else {
            this.mealService.updateMeal(u);
        }
        return "redirect:/meal";
    }

    @RequestMapping("/meal/remove/{mealId}")
    public String removeMeal(@PathVariable("mealId") int mealId) {

        this.mealService.removeMeal(mealId);
        return "redirect:/meal";
    }

    @RequestMapping("/meal/edit/{mealId}")
    public String editMeal(@PathVariable("mealId") int id, Model model) {
        model.addAttribute("meal", this.mealService.getMealById(id));
        model.addAttribute("listMeal", this.mealService.listMeals());
        return "meal.jsp";
    }

    @RequestMapping(value = "/meal/list/{companyId}", method = RequestMethod.GET)
    public List<MealDto> listMeals(@PathVariable("companyId") int companyId) {
        return mealService.listMealByCompany(companyId);
    }

}
