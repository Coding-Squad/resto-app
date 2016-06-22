package com.reminisense.ra.service;

import com.reminisense.ra.dao.AssetDao;
import com.reminisense.ra.dao.CompanyDao;
import com.reminisense.ra.dao.UserDao;
import com.reminisense.ra.dto.factory.AssetFactory;
import com.reminisense.ra.dto.json.AssetDto;
import com.reminisense.ra.entity.AssetEntity;
import com.reminisense.ra.entity.CompanyEntity;
import com.reminisense.ra.entity.UserEntity;
import com.reminisense.ra.exception.CompanyNotFoundException;
import com.reminisense.ra.exception.RegistrationException;
import com.reminisense.ra.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nigs on 2016-05-24.
 */
@Service
public class AssetServiceImpl implements AssetService {

    private static final Logger logger = LoggerFactory
            .getLogger(AssetServiceImpl.class);
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private AssetDao assetDao;
    @Autowired
    private UserDao userDao;

    @Override
    public AssetDto addAsset(AssetDto asset) throws RegistrationException {
        // get company:
        int companyId = asset.getCompanyId();
        CompanyEntity company = companyDao.getCompanyById(companyId);
        if (company == null) {
            throw new RegistrationException("Company does not exist!");
        }

        // get owner:
        int ownerId = asset.getOwnerId();
        UserEntity owner;
        if (ownerId == 0) {
            // not assigned to anyone.
            owner = null;
        } else {
            owner = userDao.getUserById(ownerId);
            if (owner == null) {
                throw new RegistrationException("User does not exist!");
            }
        }

        // check if asset tag already exists
        AssetEntity dbAsset = null;
        switch (asset.getTagType()) {
            case 1:
                dbAsset = assetDao.getAssetByCompanyAndRfidTag(asset.getCompanyId(), asset.getTag());
                break;
            case 2:
                dbAsset = assetDao.getAssetByCompanyAndBarCode(asset.getCompanyId(), asset.getTag());
                break;
            case 3:
                dbAsset = assetDao.getAssetByCompanyAndQrCode(asset.getCompanyId(), asset.getTag());
                break;
        }

        if (dbAsset != null) {
            throw new RegistrationException("Asset with tag already exists for this company.");
        }

        try {
            // register asset
            AssetEntity newAsset = new AssetEntity();
            newAsset.setCompany(company);
            newAsset.setOwner(owner);
            newAsset.setName(asset.getName());
            newAsset.setDescription(asset.getDescription());
            newAsset.setImages(asset.getImageUrls());
            switch (asset.getTagType()) {
                case 1:
                    newAsset.setRfidTag(asset.getTag());
                    break;
                case 2:
                    newAsset.setBarCode(asset.getTag());
                    break;
                case 3:
                    newAsset.setQrCode(asset.getTag());
            }
            newAsset.setTakeOutAllowed((byte) (asset.isTakeOutAllowed() ? 1 : 0));
            newAsset.setTakeOutInfo(asset.getTakeOutInfo());

            newAsset = assetDao.addAsset(newAsset);
        } catch (Exception e) {
            logger.error("Failed to register asset.", e);
            throw new RegistrationException("Failed to register asset.", e);
        }

        return asset;
    }

    @Override
    public List<AssetDto> listAssets() {
        return AssetFactory.toAssetDtoList(assetDao.listAssets());
    }

    @Override
    public List<AssetDto> listAssetsByUser(int userId) throws UserNotFoundException {
        UserEntity userEntity = userDao.getUserById(userId);
        if(userEntity == null) {
            throw new UserNotFoundException(String.format("User ID: %s not found", userId));
        }

        return AssetFactory.toAssetDtoList(assetDao.listAssetsByUser(userEntity));

    }

    @Override
    public List<AssetDto> listAssetsByCompany(int companyId) throws CompanyNotFoundException {
        CompanyEntity companyEntity = companyDao.getCompanyById(companyId);
        if(companyEntity == null) {
            throw new CompanyNotFoundException(String.format("Company ID: %s not found", companyId));
        }

        return AssetFactory.toAssetDtoList(assetDao.listAssetsByCompany(companyEntity));
    }
}
