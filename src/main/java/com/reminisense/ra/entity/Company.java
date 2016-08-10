package com.reminisense.ra.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by Yumi on 7/12/2016.
 */
@Entity
@Table(name = "company", schema = "restoapp_db")
public class Company implements Serializable
{
    private Set<Meal> meals;

    private int companyId;
    private String name;
    private String address;
    private String phone;

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    public Set<Meal> getMeals() {return meals;}
    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    public int getCompanyId() {
        return companyId;
    }
    public void setCompanyId(int companyid) {
        this.companyId = companyid;
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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }


    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }


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
        return "Company{" +
                ", companyId=" + companyId +
                ", meals='" + meals + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';

    }

}
