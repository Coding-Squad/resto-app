package com.reminisense.ra.dto.factory;

import com.reminisense.ra.dto.json.AssetDto;
import com.reminisense.ra.entity.AssetEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nigs on 2016-06-06.
 */
public final class AssetFactory {
    private static boolean nullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static AssetDto createAssetDto(AssetEntity assetEntity) {
        String tag;
        int tagType;
        if (!nullOrEmpty(assetEntity.getRfidTag())) {
            tag = assetEntity.getRfidTag();
            tagType = 1;
        } else if(!nullOrEmpty(assetEntity.getBarCode())) {
            tag = assetEntity.getBarCode();
            tagType = 2;
        } else if(!nullOrEmpty(assetEntity.getQrCode())) {
            tag = assetEntity.getBarCode();
            tagType = 3;
        } else {
            tag = "";
            tagType = 0;
        }

        return new AssetDto(assetEntity.getAssetId(),
                assetEntity.getCompany().getCompanyId(),
                assetEntity.getOwner().getUserId(),
                assetEntity.getName(),
                assetEntity.getDescription(),
                assetEntity.getImages(),
                tag,
                tagType,
                assetEntity.getTakeOutAllowed() == 1 ? true : false,
                assetEntity.getTakeOutInfo()
                );
    }

    public static List<AssetDto> toAssetDtoList(List<AssetEntity> assetEntities) {
        List<AssetDto> assetDtos = new ArrayList<>();
        for(AssetEntity asset: assetEntities) {
            assetDtos.add(AssetFactory.createAssetDto(asset));
        }
        return assetDtos;
    }
}
