package com.reminisense.ra.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Yumi on 7/12/2016.
 */
@Entity
@Table(name = "meal", schema = "restoapp_db")
public class Meal implements Serializable {

    private Company company;
    private int mealId;
    private String name;
    private String description;
    private Integer price;
    private Integer quantity;

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", nullable = false)
     public Company getCompany() {return company;}
//    public Set<Company> getCompany() {return (Set<Company>) company;}
    public void setCompany(Company company) {
        this.company = company;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
        return "Meal{" +
                ", company=" + company +
                ", mealId=" + mealId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';

    }


}
