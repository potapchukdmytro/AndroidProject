package com.example.firstproject.security;

public interface JwtSecurityService {
    void saveJwtToken(String token);
    String getToken();
    void deleteToken();
    boolean isAuth();
    String decoded();
}
