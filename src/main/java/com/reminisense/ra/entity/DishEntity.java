package com.reminisense.ra.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Yumi on 7/7/2016.
 */

@Entity
@Table(name = "dish", schema = "restoapp_db")
public class DishEntity {

        private int dishId;
        private int quantity;
        private String dish_name;
        private int dish_price;
        private Timestamp createdAt;
        private Timestamp updatedAt;
        private Timestamp deletedAt;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "dish_id")
        public int getDishId() {
        return dishId;
        }
        public void setDishId(int dish_id) {
        this.dishId = dish_id;
    }

        @Basic
        @Column(name = "quantity")
        public int getQuantity() {
            return quantity;
        }
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }


        @Basic
        @Column(name = "dish_name")
        public String getDish_name() {
            return dish_name;
        }
        public void setDish_name(String dish_name) {
            this.dish_name = dish_name;
        }


        @Basic
        @Column(name = "dish_price")
        public int getDish_price() {
            return dish_price;
        }
        public void setDish_price (int dish_price) {
            this.dish_price  = dish_price;
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
        return "UserEntity{" +
                ", dishId=" + dishId +
                ", quantity='" + quantity + '\'' +
                ", dish_name='" + dish_name + '\'' +
                ", dish_price='" + dish_price + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }

}


