package com.reminisense.ra.service;

import com.reminisense.ra.dao.UserDao;
import com.reminisense.ra.dto.factory.UserFactory;
import com.reminisense.ra.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Nigs on 2016-05-21.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Value("${superadmin.user}")
    private String admin;

    @Value("${superadmin.pass}")
    private String pass;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = this.userDao.findByEmail(email);
        // in-memory user
        if (email.equals(admin)) {
            user = new UserEntity();
            user.setEmail(admin);
            user.setPassword(pass);
            user.setAuthorities("ROLE_ADMIN");
            user.setFirstName("SUPER ADMIN");
            user.setLastName("SUPER ADMIN");
            user.setCompanyId(0);
        }

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with email '%s'.", email));
        } else {
            return UserFactory.create(user);
        }
    }

}
