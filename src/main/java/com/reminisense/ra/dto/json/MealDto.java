package com.reminisense.ra.dto.json;

import javax.validation.constraints.NotNull;

/**
 * Created by Yumi on 7/13/2016.
 */
public class MealDto {
    private int mealId;
    @NotNull
    private Integer companyId;
    @NotNull
    private String name;
    @NotNull
    private String description;
    private Integer price;
    private Integer quantity;

    public MealDto()
    {
    }


    public MealDto(int mealId, Integer companyId, String name, String description, int price, Integer quantity)

    {
        this.mealId=mealId;
        this.companyId = companyId;
        this.name=name;
        this.description=description;
        this.price=price;
        this.quantity=quantity;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getCompanyId() {return companyId;}

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice(){return price;}

    public void setPrice(Integer price){this.price = price;}

    public Integer getQuantity(){return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

}
