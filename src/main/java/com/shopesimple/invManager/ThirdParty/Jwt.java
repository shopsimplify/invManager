package com.shopesimple.invManager.ThirdParty;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Jwt {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

public String generateToken(String emailId){
    Map<String,Object> claims = new HashMap<>();

    return Jwts.builder()
            .setClaims(claims)
            .setSubject(emailId)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+expiration))
            .signWith(SignatureAlgorithm.HS512,secret)
            .compact();
}

 //***************************************************
    private Claims extractClaims(String token){
        return Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token).getBody();
    }
    //***************************************************
    public String extractUsername(String token){
        return extractClaims(token).getSubject();
    }
    //***************************************************
    public Date extractExpiration(String token){
        return extractClaims(token).getExpiration();
    }
    //***************************************************
    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    //***************************************************
    public  boolean validateToken(String token, String emailId){
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(emailId)&&!isTokenExpired(token));

    }

}
