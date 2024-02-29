package com.example.ClubNauticoSpring2.dto;

import lombok.Data;

@Data
public class JWTAuthResponseDTO {

    private String token;
    private String refreshToken;
}
