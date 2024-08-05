package com.adobe.prj.orderapp.security.service;

import com.adobe.prj.orderapp.security.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSigningKey; // read from application.properties

    public String generateTokenUtil(UserDetails userDetails) {
        System.out.println("generateTokenUtil");
        Map<String,Object> claims = new HashMap<>();
        String token =  generateToken(claims, userDetails);
        System.out.println("Token :" + token);
        return token;
    }

    private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        Collection<String> authorities = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        User user = (User) userDetails;
        return Jwts.builder()
                .setClaims(extraClaims)
//                .setSubject(userDetails.getUsername())
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .claim("roles",authorities)
                .claim("authorities", authorities)
//				.claim("iss", "http://server.adobe.com")
                .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
