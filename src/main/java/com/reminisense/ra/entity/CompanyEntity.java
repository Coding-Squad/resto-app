package com.reminisense.ra.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rubyline on 7/10/2016.
 */
@Entity
@Table(name = "company", schema = "restoapp_db")
public class CompanyEntity implements java.io.Serializable {
    private int companyId;
    private String name;
    private Set<MealEntity> mealEntity = new HashSet<MealEntity>(0);
    private String address;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    public Set<MealEntity> getMealEntity() {
        return this.mealEntity;
    }

    public void setMealEntity(Set<MealEntity> mealEntity) {
        this.mealEntity = mealEntity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resto_id")
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
        return "CompanyEntity{" +
                ", companyId=" + companyId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';

    }


}
