package com.example.demo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtils {

    // Minimum 256-bit key (32 bytes) for HS256
    // private static final String SECRET_KEY = "your-256-bit-secret-key-your-256-bit-secret-key";
    private static final String SECRET_KEY = "Zm9vYmFyMTIzNDU2Nzg5MGFiY2RlZmdoaWprbG1u"; 

    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    // Generate JWT token
    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), Jwts.SIG.HS256)  // new syntax
                .compact();
    }

    // Extract username from token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Extract expiration date
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Extract specific claim using a resolver function
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Validate token
    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return extractedUsername.equals(username) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Extract all claims (core part of token decoding)
    private Claims extractAllClaims(String token) {
        JwtParser parser = Jwts.parser()
                .verifyWith(getSigningKey())  // verifyWith in 0.12.x
                .build();

        return parser.parseSignedClaims(token).getPayload();
    }

    // Utility: Print a random secure secret key (for use in app config)
    public static void printSecretKey() {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println("Generated Base64 Secret Key: " + base64Key);
    }
}
