package com.example.snap.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    // Create a secret signing key (should be kept private and long-term safe)
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // HS256 = HMAC SHA-256
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour in milliseconds

    // Create a JWT token with a username
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)  // who is the token for
                .setIssuedAt(new Date()) // when was it created
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // when it expires
                .signWith(key) // signing key and algorithm
                .compact();
    }

    // Extract username from a JWT token
    public static String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key) // verify signature with this key
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Check if token is valid (not expired, and username matches)
    public static boolean isTokenValid(String token, String expectedUsername) {
        try {
            String username = extractUsername(token);
            return username.equals(expectedUsername) && !isTokenExpired(token);
        } catch (Exception e) {
            return false; // if something fails, token is not valid
        }
    }

    // Check if token is expired
    public static boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
}