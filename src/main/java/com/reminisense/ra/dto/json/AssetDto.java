package com.reminisense.ra.dto.json;

import javax.validation.constraints.NotNull;

/**
 * Created by Nigs on 2016-05-16.
 */
public class AssetDto {
    private int assetId;
    @NotNull
    private int companyId;
    @NotNull
    private int ownerId;
    @NotNull
    private String name;
    private String description;
    private String imageUrls;
    @NotNull
    private String tag;
    @NotNull
    private int tagType;
    @NotNull
    private boolean takeOutAllowed;
    private String takeOutInfo;

    public AssetDto() {
    }

    /**
     *
     * @param assetId
     * @param companyId
     * @param ownerId
     * @param name
     * @param description
     * @param imageUrls
     * @param tag
     * @param tagType
     * @param takeOutAllowed
     * @param takeOutInfo
     */
    public AssetDto(int assetId, int companyId, int ownerId, String name, String description, String imageUrls, String tag, int tagType, boolean takeOutAllowed, String takeOutInfo) {
        this.assetId = assetId;
        this.companyId = companyId;
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
        this.imageUrls = imageUrls;
        this.tag = tag;
        this.tagType = tagType;
        this.takeOutAllowed = takeOutAllowed;
        this.takeOutInfo = takeOutInfo;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
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

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTagType() {
        return tagType;
    }

    public void setTagType(int tagType) {
        this.tagType = tagType;
    }

    public boolean isTakeOutAllowed() {
        return takeOutAllowed;
    }

    public void setTakeOutAllowed(boolean takeOutAllowed) {
        this.takeOutAllowed = takeOutAllowed;
    }

    public String getTakeOutInfo() {
        return takeOutInfo;
    }

    public void setTakeOutInfo(String takeOutInfo) {
        this.takeOutInfo = takeOutInfo;
    }
}
