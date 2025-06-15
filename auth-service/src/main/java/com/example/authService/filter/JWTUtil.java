package com.example.authService.filter;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JWTUtil {
    private static final String SECRET_KEY = "x7qF5q1W1ReynGqckb1++OE1ncfWZbkKUbTKq41MoDk=";
    private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    //Generate Token
    public String generateToken(String email, long expiryMinutes) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setIssuedAt(new Date(System.currentTimeMillis() + expiryMinutes * 60 * 1000))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public  String validateAndExtractUsername(String token) {
        try{
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (JwtException ex) {
            System.out.println("JwtException " + ex.getMessage());
            return  null;
        }
    }
}
