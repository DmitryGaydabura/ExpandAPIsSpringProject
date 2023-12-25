package com.example.expandapisspringproject.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
@Configuration
public class JwtUtil {

    private String secret = "your-secret-key"; // Use a strong secret key

    public String generateToken(String username) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        long expMillis = nowMillis + 3600000; // Token validity 1 hour
        Date exp = new Date(expMillis);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    // Add method to validate token if needed
}

