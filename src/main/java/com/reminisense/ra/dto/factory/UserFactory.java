package com.reminisense.ra.dto.factory;

import com.reminisense.ra.dto.SecuredUserDetails;
import com.reminisense.ra.dto.json.LoginResultDto;
import com.reminisense.ra.dto.json.UserDto;
import com.reminisense.ra.entity.UserEntity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.util.StringUtils;

/**
 * Created by caspe on 7/11/2016.
 */
public class UserFactory {


    public static SecuredUserDetails create(UserEntity userEntity) {
        if (userEntity == null) return null;
        return new SecuredUserDetails(
                userEntity.getUserId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getAddress(),
                userEntity.getPhone(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getLastPasswordReset(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(userEntity.getAuthorities())
        );

    }

    public static UserDto createUserDto(UserEntity userEntity) {

        if (userEntity == null) return null;

        return new UserDto(
        userEntity.getUserId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getAddress(),
                userEntity.getPhone(),
                userEntity.getEmail(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getPassword(),
                userEntity.getAuthorities());
    }

    public static UserEntity createUserEntity(UserDto p) {
        UserEntity ue = new UserEntity();
        ue.setUserId(p.getUserId());
        ue.setFirstName(p.getFirstName());
        ue.setLastName(p.getLastName());
        ue.setAddress(p.getAddress());
        ue.setPhone(p.getPhone());
        ue.setUsername(p.getUsername());
        ue.setEmail(p.getEmail());
        ue.setPassword(p.getPassword());
        ue.setAuthorities(p.getAuthorities());
        return ue;
    }

    public static LoginResultDto createLoginResultDto(SecuredUserDetails sud, String token) {
        LoginResultDto dto = new LoginResultDto();
        dto.setAuthenticationToken(token);
        dto.setFirstName(sud.getFirstName());
        dto.setLastName(sud.getLastName());
        dto.setUserId(sud.getUserId());
        dto.setRoles(StringUtils.collectionToCommaDelimitedString(AuthorityUtils.authorityListToSet(sud.getAuthorities())));
        return dto;
    }
}
