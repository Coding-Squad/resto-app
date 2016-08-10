package com.reminisense.ra.service;

import com.reminisense.ra.dao.CompanyDao;
import com.reminisense.ra.dao.MealDao;
import com.reminisense.ra.dto.factory.MealFactory;
import com.reminisense.ra.dto.json.MealDto;
import com.reminisense.ra.entity.Company;
import com.reminisense.ra.entity.Meal;
import com.reminisense.ra.exception.RegistrationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yumi on 7/14/2016
 */
@Service
public class MealServiceImpl implements MealService {

    private static final Logger logger = LoggerFactory
            .getLogger(MealService.class);
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private MealDao mealDao;



    public MealDto addMeal(MealDto m) throws RegistrationException {
        // check company

        Company company = companyDao.getCompanyById(m.getCompanyId());
        if (company == null) {
            throw new RegistrationException("Company does not exist.");
        }
        MealDto mealDto = MealFactory.createMealDto(
                mealDao.addMeal(MealFactory.createMeal(m, company)));
        return mealDto;

//                MealFactory.createMealDto(
//               mealDao.addMeal(MealFactory.createMeal(m, company)));

    }




/*  // rub stressful code
        // check company
        Company company = companyDao.getCompanyById(m.getCompanyId());
        if (company == null) {
            throw new RegistrationException("Company does not exist.");
        }
        return  MealFactory.createMealDto(
               mealDao.addMeal(MealFactory.createMeal(m, company)));
*/

  /*  @Override
    public List<MealDto> listMeals() {
        List<MealDto> m = new ArrayList<MealDto>();
        List<Meal> meals = mealDao.listMeals();
        for (Meal meal : meals) {
            m.add(MealFactory.createMealDto(meal));
        }
            return m;

    }*/

    @Override
    public List<MealDto> listMeals() {
        List<MealDto> m = new ArrayList<MealDto>();
        List<Meal> meals = mealDao.listMeals();
        for (Meal meal : meals) {
            m.add(MealFactory.createMealDto(meal));
        }
        return m;

    }


    /*@Override
    public List<MealDto> listMealByCompany ( Integer companyId){
      List<MealDto> m = new ArrayList<MealDto>();
            List<Meal> meals = mealDao.listMealByCompanyId(companyId);
            for (Meal meal : meals) {
                m.add(MealFactory.createMealDto(meal));
            }
            return m;
        }*/
    @Override
    public List<MealDto> listMealByCompany (int companyId){
        List<MealDto> m = new ArrayList<MealDto>();
        List<Meal> meals = mealDao.listMealByCompanyId(companyId);
        for (Meal meal : meals) {
            m.add(MealFactory.createMealDto(meal));
        }
        return m;
    }

          /*  try {
                company.setName(m.getName());
                assetEntity.setDescription(assetDto.getDescription());
                assetEntity.setTakeOutInfo(assetDto.getTakeOutInfo());
                assetEntity.setValidUntil(DateUtil.toTimestampOrNull(assetDto.getValidUntil()));
                setAssetTagFromType(assetEntity, assetDto.getTagType(), assetDto.getTag());
                assetEntity.setTakeOutAllowed((byte) (assetDto.isTakeOutAllowed() ? 1 : 0));
                assetEntity.setTakeOutInfo(assetDto.getTakeOutInfo());

                return AssetFactory.createAssetDto(assetDao.updateAsset(assetEntity));
            } catch (Exception e) {
                logger.error("Failed to update asset because: " + e.getMessage());
                throw new DatabaseUpdateFailedException(e.getMessage());
            }*/




     /*  @Override
       public MealDto getMealByCompanyId(GetMealByCompanyDto dto) {
           if (dto == null) {
               throw new MealNotFoundException("Request can not be null.");
           }

//           if (dto.getTagType() == 0) {
//               throw new AssetNotFoundException("Tag type is required.");
//           }

           if (dto.getCompanyId() == 0 ) {
               throw new MealNotFoundException("Invalid parameters.");
           }

           return dto;
       }*/

    @Override
    public MealDto updateMeal (MealDto m)throws RegistrationException {
        Company company = companyDao.getCompanyById(m.getCompanyId());
        if (company == null) {
            throw new RegistrationException("Company does not exist.");
        }
        return MealFactory.createMealDto(
                mealDao.updateMeal(MealFactory.createMeal(m, company)));
    }


    @Override
    public Meal getMealById (int id){
        return mealDao.getMealById(id);
    }

    @Override
    public void removeMeal ( int id){
        mealDao.removeMeal(id);
    }

}
