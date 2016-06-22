package com.reminisense.ra.dto.factory;

import com.reminisense.ra.dto.SecuredUserDetails;
import com.reminisense.ra.dto.json.UserDto;
import com.reminisense.ra.entity.UserEntity;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by Nigs on 2016-05-21.
 */
public final class UserFactory {

    public static SecuredUserDetails create(UserEntity userEntity) {
        return new SecuredUserDetails(
                userEntity.getUserId(),
                userEntity.getCompanyId(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getLastPasswordReset(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(userEntity.getAuthorities())
        );
    }

    public static UserDto createUserDto(UserEntity userEntity) {

        return new UserDto(
                userEntity.getUserId(),
                userEntity.getCompanyId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getPosition(),
                userEntity.getDescription(),
                userEntity.getImageUrl(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getPassword(),
                userEntity.getAuthorities());
    }

    public static UserEntity createUserEntity(UserDto p) {
        UserEntity ue = new UserEntity();
        ue.setUserId(p.getUserId());
        ue.setCompanyId(p.getCompanyId());
        ue.setFirstName(p.getFirstName());
        ue.setLastName(p.getLastName());
        ue.setPosition(p.getPosition());
        ue.setDescription(p.getDescription());
        ue.setImageUrl(p.getImageUrl());
        ue.setEmail(p.getEmail());
        ue.setPassword(p.getPassword());
        ue.setAuthorities(p.getAuthorities());
        return ue;
    }
}
