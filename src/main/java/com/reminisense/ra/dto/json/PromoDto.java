package com.reminisense.ra.dto.json;

import javax.validation.constraints.NotNull;

/**
 * Created by Rubyline on 8/2/2016.
 */
public class PromoDto {
    private int promoId;
    private Integer mealId;
    @NotNull
    private String name;
    @NotNull
    private String description;
    private Integer discount;
    private Integer quantity;

    public PromoDto()
    {
    }
    public PromoDto(int promoId, Integer mealId, String name, String description, Integer discount, Integer quantity)

    {
        this.promoId = promoId;
        this.mealId=mealId;
        this.name=name;
        this.description=description;
        this.discount=discount;
        this.quantity=quantity;
    }


    public int getPromoId() {
        return promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
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

    public Integer getDiscount(){return discount;}

    public void setDiscount(Integer discount){this.discount =discount;}

    public Integer getQuantity(){return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}
}
