package com.sougata.ecommerce.project.security.jwt;

import java.util.List;

public class LoginResponse {

    private String JwtToken;
    private String username;
    private List<String> roles;

    public LoginResponse(String jwtToken, String username, List<String> roles) {
        JwtToken = jwtToken;
        this.username = username;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJwtToken() {
        return JwtToken;
    }

    public void setJwtToken(String jwtToken) {
        JwtToken = jwtToken;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
