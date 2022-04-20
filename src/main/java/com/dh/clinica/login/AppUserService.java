package com.dh.clinica.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AppUserService implements UserDetailsService {

    private final UserRepositoy userRepositoy;

    @Autowired
    public AppUserService(UserRepositoy userRepositoy) {
        this.userRepositoy = userRepositoy;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepositoy.findByEmail(email).orElseThrow((()-> new  UsernameNotFoundException("User email not found")));
    }
}
