package com.example.ingressacademytask.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String SECRET_KEY;
    public String findUserName(String token) {
        return  exportToken(token, Claims::getSubject);
    }
    private <T>  T exportToken(String token, Function<Claims, T> claimsFunction) {
        final Claims claims = Jwts.parserBuilder()
                .setSigningKey(stKey())
                .build().parseClaimsJws(token).getBody();
        return claimsFunction.apply(claims);

    }
    private Key stKey() {
        byte[] key = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(key);
    }
    public boolean tokenControl(String jwt, UserDetails userDetails) {
        final String userName= findUserName(jwt);
        return (userName.equals(userDetails.getUsername()) && !exportToken(jwt, Claims::getExpiration).before(new Date()));
    }
    public String  generateToken(UserDetails users) {
        return Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(users.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *24))
                .signWith(stKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
