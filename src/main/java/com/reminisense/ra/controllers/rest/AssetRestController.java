package com.reminisense.ra.controllers.rest;

import com.reminisense.ra.dto.json.*;
import com.reminisense.ra.exception.RegistrationException;
import com.reminisense.ra.exception.VerificationException;
import com.reminisense.ra.service.AssetService;
import com.reminisense.ra.service.VerificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Nigs on 2016-05-24.
 */
@RestController
@RequestMapping(value = "/api")
public class AssetRestController {
    private static final Logger logger = LoggerFactory
            .getLogger(AssetRestController.class);
    @Autowired
    private VerificationService verificationService;
    @Autowired
    private AssetService assetService;

    @RequestMapping(value = "/asset/add", method = RequestMethod.POST)
    public RestResultDto registerAsset(@Valid @RequestBody AssetDto assetDto, BindingResult result) {
        if (result.hasErrors()) {
            // validation..
            return new RestResultDto(RestResultDto.RESULT_ERROR, "Invalid data.");
        }
        try {
            assetService.addAsset(assetDto);
            return new RestResultDto(RestResultDto.RESULT_OK);
        } catch (RegistrationException e1) {
            return new RestResultDto(RestResultDto.RESULT_ERROR, e1.getMessage());
        } catch (Exception e) {
            logger.error("Register asset: ", e);
            return new RestResultDto(RestResultDto.RESULT_ERROR, e.getMessage());
        }
    }


    @RequestMapping(value = "/asset/verify", method = RequestMethod.POST)
    public VerifyResultDto verify(@Valid @RequestBody VerifyRequestDto dto) {
        try {
            return verificationService.verify(dto);
        } catch (VerificationException e) {
            return new VerifyResultDto(RestResultDto.RESULT_ERROR, e.getMessage());
        } catch (Exception e) {
            logger.error("Verify asset: ", e);
            return new VerifyResultDto(RestResultDto.RESULT_ERROR, e.getMessage());
        }
    }

    @RequestMapping(value = "/asset/transact", method = RequestMethod.POST)
    public RestResultDto transact(@Valid @RequestBody TransactRequestDto dto) {
        try {
            verificationService.transact(dto);
            return new RestResultDto(RestResultDto.RESULT_OK);
        } catch (VerificationException e) {
            return new RestResultDto(RestResultDto.RESULT_ERROR, e.getMessage());
        } catch (Exception e) {
            logger.error("Transact asset: ", e);
            return new RestResultDto(RestResultDto.RESULT_ERROR, e.getMessage());
        }
    }

}
