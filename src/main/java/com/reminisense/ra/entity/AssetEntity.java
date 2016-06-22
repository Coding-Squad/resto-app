package com.reminisense.ra.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Nigs on 2016-05-12.
 */
@Entity
@Table(name = "asset", schema = "feather_assets")
public class AssetEntity implements Serializable {
    private CompanyEntity company;
    private int assetId;
    private UserEntity owner;
    private String name;
    private String description;
    private String images;
    private String rfidTag;
    private String qrCode;
    private String barCode;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private byte takeOutAllowed;
    private String takeOutInfo;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", nullable = false)
    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity user) {
        this.owner = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asset_id")
    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
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
    @Column(name = "images")
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Basic
    @Column(name = "rfid_tag")
    public String getRfidTag() {
        return rfidTag;
    }

    public void setRfidTag(String rfidTag) {
        this.rfidTag = rfidTag;
    }

    @Basic
    @Column(name = "qr_code")
    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @Basic
    @Column(name = "bar_code")
    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
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

    @Basic
    @Column(name = "take_out_allowed")
    public byte getTakeOutAllowed() {
        return takeOutAllowed;
    }

    public void setTakeOutAllowed(byte takeOutAllowed) {
        this.takeOutAllowed = takeOutAllowed;
    }

    @Basic
    @Column(name = "take_out_info")
    public String getTakeOutInfo() {
        return takeOutInfo;
    }

    public void setTakeOutInfo(String takeOutInfo) {
        this.takeOutInfo = takeOutInfo;
    }

    @Override
    public String toString() {
        return "AssetEntity{" +
                "assetId=" + assetId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", images='" + images + '\'' +
                ", rfidTag='" + rfidTag + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", barCode='" + barCode + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                ", takeOutAllowed=" + takeOutAllowed +
                ", takeOutInfo='" + takeOutInfo + '\'' +
                '}';
    }
}
