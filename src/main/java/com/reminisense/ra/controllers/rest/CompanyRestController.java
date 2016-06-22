package com.reminisense.ra.controllers.rest;

import com.reminisense.ra.dto.json.RestResultDto;
import com.reminisense.ra.exception.CompanyNotFoundException;
import com.reminisense.ra.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nigs on 2016-06-06.
 */
@RestController
@RequestMapping(value = "/api")
public class CompanyRestController {

    @Autowired
    private AssetService assetService;

    @RequestMapping(value = "/company/{companyId}/assets/list", method = RequestMethod.GET)
    public ResponseEntity<?> listCompanyAssets(@PathVariable("companyId") int companyId) {
        try {
            return new ResponseEntity<>(assetService.listAssetsByCompany(companyId), HttpStatus.OK);
        } catch (CompanyNotFoundException e) {
            return new ResponseEntity<>(new RestResultDto(RestResultDto.RESULT_ERROR, "Company not found."), HttpStatus.NOT_FOUND);
        }
    }
}
