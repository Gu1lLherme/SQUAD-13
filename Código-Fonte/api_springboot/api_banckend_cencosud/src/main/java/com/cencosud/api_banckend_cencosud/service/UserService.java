package com.cencosud.api_banckend_cencosud.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements UserDetailsService {

    private Map<String, String> users = new HashMap<>();

    public UserService() {
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = users.get(username);
        if (password == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(username, password, new ArrayList<>());
    }
}
