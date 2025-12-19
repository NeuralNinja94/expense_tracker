package com.expensetracker.backend.util;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    //Generiert und validiert JWT Tokens

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expirationMs}")
    private Long expirationMs;

    private SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(secret.getBytes());

    }

    //Token genererieren
    public String generateToken(String benutzername, Long userId){
        return Jwts.builder()
                .setSubject(benutzername)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //Benutzername aus Token extrahieren
    public String getUsernameFromToken(String token){
        return getClaims(token).getSubject();
    
}

// UserId aus Token extrahieren
public Long getUserIdFromToken(String token){
    return getClaims(token).get("userId", Long.class);
}

    //Token validieren
    public boolean validateToken(String token){
        try{
            Claims claims = getClaims(token);
            Date expiration = claims.getExpiration();
            return !expiration.before(new Date());
        } catch (Exception e){
            return false;
        }
    }

    private Claims getClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isTokenExpired(String token){
        return getClaims(token).getExpiration().before(new Date());
    }
}
