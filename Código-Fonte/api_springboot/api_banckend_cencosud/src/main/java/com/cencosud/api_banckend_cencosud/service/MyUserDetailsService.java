package com.cencosud.api_banckend_cencosud.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Para fins de exemplo, retornando um usuário fixo
        return new org.springframework.security.core.userdetails.User(
                "user",
                "{noop}password",
                new ArrayList<>()
        );
    }
}

