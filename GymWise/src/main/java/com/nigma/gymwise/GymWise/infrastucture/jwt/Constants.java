package com.nigma.gymwise.GymWise.infrastucture.jwt;

import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;

public class Constants {

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    public static final String SUPER_SECRET_KEY = "pA%WKMLHQ(0QT#{ad0@z4-tZ355]YA.Wr*AYKJHT}1hkJRxy.fU+&6(?jk3aYTx9L3u3+u";
    public static final long TOKEN_EXPIRATION_TIME = 1500000;

    public static Key getSignedKey(String secretKey){
        byte [] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
