package com.reminisense.ra.service;

import com.reminisense.ra.dto.json.AssetDto;
import com.reminisense.ra.exception.CompanyNotFoundException;
import com.reminisense.ra.exception.RegistrationException;
import com.reminisense.ra.exception.UserNotFoundException;

import java.util.List;

/**
 * Created by Nigs on 2016-05-24.
 */
public interface AssetService {
    AssetDto addAsset(AssetDto asset) throws RegistrationException;

    List<AssetDto> listAssets();
    List<AssetDto> listAssetsByUser(int userId) throws UserNotFoundException;
    List<AssetDto> listAssetsByCompany(int companyId) throws CompanyNotFoundException;
}
