package com.reminisense.ra.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Rubyline on 8/2/2016.
 */
@Entity
@Table(name = "promo", schema = "restoapp_db")
public class Promo implements Serializable
{
    private Meal meal;
    private int promoId;
    private String name;
    private String description;
    private Integer discount;
    private Integer quantity;


    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    @ManyToOne
    @JoinColumn(name = "meal_id", referencedColumnName = "meal_id", nullable = false)
    public Meal getMeal() {return meal;}
    public void setMeal(Meal meal) {
        this.meal= meal;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promo_id")
    public int getPromoId() {
        return promoId;
    }
    public void setPromoId(int promoId) {
        this.promoId = promoId;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "discount")
    public Integer getDiscount() {
        return discount;
    }
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {this.quantity= quantity; }


    @Basic
    @CreationTimestamp
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @UpdateTimestamp
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Basic
    @Column(name = "deleted_at")
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }


    @Override
    public String toString() {
        return "Promo{" +
                ", meal=" + meal +
                ", promoId=" + promoId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", discount='" + discount + '\'' +
                ", quantity='" + quantity + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';

    }
}
