package com.reminisense.ra.dao;

import com.reminisense.ra.entity.AssetEntity;
import com.reminisense.ra.entity.CompanyEntity;
import com.reminisense.ra.entity.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nigs on 2016-04-15.
 */
@Repository
@Transactional
public class AssetDaoImpl implements AssetDao {
    private static final Logger logger = LoggerFactory
            .getLogger(AssetDaoImpl.class);

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public AssetEntity addAsset(AssetEntity p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Asset saved successfully, Asset Details=" + p);
        return p;
    }

    public AssetEntity updateAsset(AssetEntity p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Asset updated successfully, Asset Details=" + p);
        return p;
    }

    @SuppressWarnings("unchecked")
    public List<AssetEntity> listAssets() {
        Session session = this.sessionFactory.getCurrentSession();
        List<AssetEntity> assetsList = session.createQuery("from AssetEntity ").list();
        for (AssetEntity p : assetsList) {
            logger.info("Asset List::" + p);
        }
        return assetsList;
    }

    @Override
    public List<AssetEntity> listAssetsByUser(UserEntity userEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        List<AssetEntity> assetsList = session.createQuery("from AssetEntity where owner.userId=:userId")
                .setParameter("userId", userEntity.getUserId()).list();
        for (AssetEntity p : assetsList) {
            logger.info("Asset List:" + p);
        }
        return assetsList;
    }

    @Override
    public List<AssetEntity> listAssetsByCompany(CompanyEntity companyEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        List<AssetEntity> assetsList = session.createQuery("from AssetEntity where company.companyId=:companyId")
                .setParameter("companyId", companyEntity.getCompanyId()).list();
        for (AssetEntity p : assetsList) {
            logger.info("Asset List:" + p);
        }
        return assetsList;
    }

    public AssetEntity getAssetById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        AssetEntity p = (AssetEntity) session.load(AssetEntity.class, new Integer(id));
        logger.info("Asset loaded successfully, Asset details=" + p);
        return p;
    }

    public AssetEntity getAssetByCompanyAndRfidTag(int companyId, String tag) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(
                "from AssetEntity where company.companyId=:companyId and rfidTag=:tag")
                .setParameter("companyId", companyId)
                .setParameter("tag", tag);
        List<AssetEntity> assets = query.list();
        if (assets == null || assets.isEmpty()) {
            return null;
        }
        return assets.get(0);
    }

    public AssetEntity getAssetByCompanyAndBarCode(int companyId, String tag) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(
                "from AssetEntity where company.companyId=:companyId and barCode=:tag")
                .setParameter("companyId", companyId)
                .setParameter("tag", tag);
        List<AssetEntity> assets = query.list();
        if (assets == null || assets.isEmpty()) {
            return null;
        }
        return assets.get(0);
    }

    public AssetEntity getAssetByCompanyAndQrCode(int companyId, String tag) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(
                "from AssetEntity where company.companyId=:companyId and qrCode=:tag")
                .setParameter("companyId", companyId)
                .setParameter("tag", tag);
        List<AssetEntity> assets = query.list();
        if (assets == null || assets.isEmpty()) {
            return null;
        }
        return assets.get(0);
    }

    public void removeAsset(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        AssetEntity p = (AssetEntity) session.load(AssetEntity.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Asset deleted successfully, asset details=" + p);
    }
}
