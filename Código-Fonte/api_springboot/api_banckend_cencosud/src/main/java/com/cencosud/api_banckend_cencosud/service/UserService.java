package com.cencosud.api_banckend_cencosud.service;

import com.cencosud.api_banckend_cencosud.Util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Autowired
    private JwtUtil jwtUtil;

    public String generateToken(UserDetails userDetails) {
        return jwtUtil.generateToken(userDetails.getUsername());
    }

    public Claims validateToken(String token) {
        return jwtUtil.validateToken(token);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = jwtUtil.validateToken(token).getSubject();
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return jwtUtil.validateToken(token).getExpiration().before(new Date());
    }
}
