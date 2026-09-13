package com.sougata.ecommerce.project.security.jwt.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserInfoResponse {

    @Setter
    @Getter
    private Long id;
    @Setter
    @Getter
    private String jwtToken;
    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private List<String> roles;

    public UserInfoResponse(Long id, String jwtToken, String username, List<String> roles) {
        this.id = id;
        this.jwtToken = jwtToken;
        this.username = username;
        this.roles = roles;
    }
}
