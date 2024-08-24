package com.groceryapp.client_api.dto;

import com.groceryapp.client_api.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class AuthenticationResponse {

    private final String jwt;
    private final UserDto user;

    public AuthenticationResponse(String jwt, UserDto user) {
        this.jwt = jwt;
        this.user = user;
    }

}
