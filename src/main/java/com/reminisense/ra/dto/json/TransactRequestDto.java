package com.reminisense.ra.dto.json;

/**
 * Created by Nigs on 2016-05-17.
 */
public class TransactRequestDto {

    private int readerId;
    private int assetId;
    private String notes;

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
