package com.reminisense.ra.service;

import com.reminisense.ra.dao.AssetDao;
import com.reminisense.ra.dao.TransactionDao;
import com.reminisense.ra.dto.factory.UserFactory;
import com.reminisense.ra.dto.json.RestResultDto;
import com.reminisense.ra.dto.json.TransactRequestDto;
import com.reminisense.ra.dto.json.VerifyRequestDto;
import com.reminisense.ra.dto.json.VerifyResultDto;
import com.reminisense.ra.entity.AssetEntity;
import com.reminisense.ra.entity.TransactionEntity;
import com.reminisense.ra.exception.VerificationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Nigs on 2016-05-17.
 */
@Service
public class VerificationServiceImpl implements VerificationService {
    private static final Logger logger = LoggerFactory
            .getLogger(VerificationServiceImpl.class);
    @Autowired
    private AssetDao assetDao;
    @Autowired
    private TransactionDao transactionDao;

    @Override
    public VerifyResultDto verify(VerifyRequestDto dto) throws VerificationException {
        if (dto == null) {
            throw new VerificationException("Request can not be null.");
        }

        if (dto.getTagType() == 0) {
            throw new VerificationException("Tag type is required.");
        }

        if (dto.getCompanyId() == 0 || dto.getTag() == null || dto.getTag().isEmpty()) {
            throw new VerificationException("Invalid parameters.");
        }

        VerifyResultDto result = new VerifyResultDto();
        AssetEntity asset;

        logger.info("Verifying Asset: " + result.toString());
        switch (dto.getTagType()) {
            case 1:
                asset = assetDao.getAssetByCompanyAndRfidTag(dto.getCompanyId(), dto.getTag());
                break;
            case 2:
                asset = assetDao.getAssetByCompanyAndBarCode(dto.getCompanyId(), dto.getTag());
                break;
            case 3:
                asset = assetDao.getAssetByCompanyAndQrCode(dto.getCompanyId(), dto.getTag());
                break;
            default:
                throw new VerificationException("Unknown tag type.");
        }
        if (asset != null) {
            result.setTakeOutInfo(asset.getTakeOutInfo());
            result.setTakeOutAllowed(asset.getTakeOutAllowed() == (byte) 1);
            result.setDescription(asset.getDescription());
            result.setImageUrls(asset.getImages());
            result.setName(asset.getName());
            result.setResult(RestResultDto.RESULT_OK);
            result.setUserDto(UserFactory.createUserDto(asset.getOwner()));
        } else {
            logger.debug("No matching assets found.");
            result.setResult("ERROR");
            result.setMessage("Not found.");
        }
        // FIXME auto-transact?
        return result;
    }

    @Override
    public void transact(TransactRequestDto dto) throws VerificationException {

        TransactionEntity transaction = new TransactionEntity();

        int assetId = dto.getAssetId();
        AssetEntity asset = assetDao.getAssetById(assetId);
        if (asset == null) {
            throw new VerificationException("Asset does not exist!");
        }

        try {
            transaction.setAssetId(dto.getAssetId());
            transaction.setAssetUserId(asset.getOwner().getUserId());
            transaction.setReaderId(dto.getReaderId());
            transaction.setNotes(dto.getNotes());
            transactionDao.addTransaction(transaction);
        } catch (Exception e) {
            throw new VerificationException("Failed to insert transaction", e);
        }
    }


}
