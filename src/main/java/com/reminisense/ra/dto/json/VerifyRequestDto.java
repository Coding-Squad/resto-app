package com.reminisense.ra.dto.json;

import javax.validation.constraints.NotNull;

/**
 * Created by Nigs on 2016-05-17.
 */
public class VerifyRequestDto extends RestResultDto {
    @NotNull
    private int companyId;
    @NotNull
    private String tag;
    @NotNull
    private int tagType;

    public VerifyRequestDto() {
        super();
    }

    public VerifyRequestDto(String result, String message, int companyId, String tag, int tagType) {
        super(result, message);
        this.companyId = companyId;
        this.tag = tag;
        this.tagType = tagType;
    }

    public VerifyRequestDto(String result, int companyId, String tag, int tagType) {
        super(result);
        this.companyId = companyId;
        this.tag = tag;
        this.tagType = tagType;
    }

    public VerifyRequestDto(int companyId, String tag, int tagType) {
        this.companyId = companyId;
        this.tag = tag;
        this.tagType = tagType;
    }

    public int getTagType() {
        return tagType;
    }

    public void setTagType(int tagType) {
        this.tagType = tagType;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
