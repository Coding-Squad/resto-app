package com.reminisense.ra.entity;

import javax.persistence.*;

/**
 * Created by Rubyline on 7/11/2016.
 */
@Entity
@Table(name = "meal", schema = "restoapp_db")
public class MealEntity implements java.io.Serializable {
    private int mealId;
    private String name;
    private Integer price;
    private CompanyEntity companyEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    public CompanyEntity getCompanyEntity() {
        return this.companyEntity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    public int getMealId() {
        return mealId;
    }
    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {this.price= price; }

}
