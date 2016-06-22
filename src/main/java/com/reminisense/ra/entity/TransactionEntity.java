package com.reminisense.ra.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Nigs on 2016-05-12.
 */
@Entity
@Table(name = "transaction", schema = "feather_assets")
public class TransactionEntity implements Serializable {
    private int transactionId;
    private int readerId;
    private int assetId;
    private int assetUserId;
    private String notes;
    private Timestamp createdAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    @Id
    @Column(name = "reader_id")
    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    @Id
    @Column(name = "asset_id")
    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    @Id
    @Column(name = "asset_user_id")
    public int getAssetUserId() {
        return assetUserId;
    }

    public void setAssetUserId(int assetUserId) {
        this.assetUserId = assetUserId;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

        if (transactionId != that.transactionId) return false;
        if (readerId != that.readerId) return false;
        if (assetId != that.assetId) return false;
        if (assetUserId != that.assetUserId) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        return createdAt != null ? createdAt.equals(that.createdAt) : that.createdAt == null;

    }

    @Override
    public int hashCode() {
        int result = transactionId;
        result = 31 * result + readerId;
        result = 31 * result + assetId;
        result = 31 * result + assetUserId;
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}
