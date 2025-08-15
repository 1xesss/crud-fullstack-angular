package com.prueba1.crudfullstack.crud_fullstack_angular.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtil {

    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("clave_muy_secreta_y_larga_para_jwt123456".getBytes());
    private final long EXPIRATION_TIME = 1000 * 60 * 60;
    public String generarToken(String username, List<String> roles) {
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }
    public String obtenerUsername(String token) {
        return obtenerClaims(token).getSubject();
    }
    public boolean validarToken(String token, String username) {
        return (username.equals(obtenerUsername(token)) && !estaExpirado(token));
    }
    private boolean estaExpirado(String token) {
        return obtenerClaims(token).getExpiration().before(new Date());
    }
    private Claims obtenerClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
