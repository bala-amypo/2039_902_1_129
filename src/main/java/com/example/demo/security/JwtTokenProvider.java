package com.example.demo.security;

public class JwtTokenProvider {

    private final String secret;
    private final long validity;

    public JwtTokenProvider(String secret, long validity) {
        this.secret = secret;
        this.validity = validity;
    }

    public String generateToken(String email, String role, Long userId) {
        return email + ":" + role + ":" + userId;
    }

    public boolean validateToken(String token) {
        return token != null && token.contains(":");
    }

    public String getUsernameFromToken(String token) {
        if (token == null) {
            return null;
        }
        return token.split(":")[0];
    }
}
