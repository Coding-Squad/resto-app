package com.reminisense.ra.controllers.rest;

import com.reminisense.ra.dto.SecuredUserDetails;
import com.reminisense.ra.dto.json.LoginRequestDto;
import com.reminisense.ra.dto.json.LoginResultDto;
import com.reminisense.ra.security.TokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nigs on 2016-05-21.
 * Patterned after: https://github.com/brahalla/Cerberus
 */
@RestController
public class AuthenticationController {

    private static final Logger logger = LoggerFactory
            .getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> authenticationRequest(@RequestBody LoginRequestDto authenticationRequest) throws AuthenticationException {

        logger.info("Logging in " + authenticationRequest.toString());
        // Perform the authentication
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-authentication so we can generate token
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        String token = this.tokenUtils.generateToken(userDetails);

        // Return the token
        // TODO
        SecuredUserDetails sud = (SecuredUserDetails) userDetails;
        LoginResultDto dto = new LoginResultDto();
        dto.setAuthenticationToken(token);
        dto.setCompanyId(sud.getCompanyId());
        dto.setFirstName(sud.getFirstName());
        dto.setLastName(sud.getLastName());
        dto.setUserId(sud.getUserId());
        dto.setRoles(StringUtils.collectionToCommaDelimitedString(AuthorityUtils.authorityListToSet(sud.getAuthorities())));
        return ResponseEntity.ok(dto);
    }

    @RequestMapping(value = "/login/refresh", method = RequestMethod.GET)
    public ResponseEntity<?> authenticationRequest(HttpServletRequest request) {
        String token = request.getHeader("X-Auth-Token");
        String username = this.tokenUtils.getUsernameFromToken(token);
        SecuredUserDetails user = (SecuredUserDetails) this.userDetailsService.loadUserByUsername(username);
        if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordReset())) {
            String refreshedToken = this.tokenUtils.refreshToken(token);
            LoginResultDto dto = new LoginResultDto();
            dto.setAuthenticationToken(refreshedToken);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
