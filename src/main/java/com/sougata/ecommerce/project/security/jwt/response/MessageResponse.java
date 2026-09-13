package com.sougata.ecommerce.project.security.jwt.response;

import lombok.Getter;
import lombok.Setter;

public class MessageResponse {

    @Getter
    @Setter
    private String message;

    public MessageResponse(String message){
        this.message = message;
    }
}
