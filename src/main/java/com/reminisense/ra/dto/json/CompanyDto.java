package com.reminisense.ra.dto.json;

import javax.validation.constraints.NotNull;

/**
 * Created by Rubyline on 7/15/2016.
 */
public class CompanyDto
{
    private int companyId;
    @NotNull
    private String name;


    public CompanyDto()
    {

    }

    public int getCompanyId() {return companyId;}
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}

