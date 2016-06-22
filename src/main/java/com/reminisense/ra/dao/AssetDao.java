package com.reminisense.ra.dao;

import com.reminisense.ra.entity.AssetEntity;
import com.reminisense.ra.entity.CompanyEntity;
import com.reminisense.ra.entity.UserEntity;

import java.util.List;

/**
 * Created by Nigs on 2016-04-15.
 */
public interface AssetDao {
    AssetEntity addAsset(AssetEntity p);

    AssetEntity updateAsset(AssetEntity p);

    List<AssetEntity> listAssets();
    List<AssetEntity> listAssetsByUser(UserEntity userEntity);
    List<AssetEntity> listAssetsByCompany(CompanyEntity companyEntity);

    AssetEntity getAssetById(int id);

    AssetEntity getAssetByCompanyAndRfidTag(int companyId, String tag);

    AssetEntity getAssetByCompanyAndBarCode(int companyId, String tag);

    AssetEntity getAssetByCompanyAndQrCode(int companyId, String tag);

    void removeAsset(int id);
}
