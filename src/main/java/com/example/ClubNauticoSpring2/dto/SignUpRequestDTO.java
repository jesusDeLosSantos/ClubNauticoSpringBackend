package com.example.ClubNauticoSpring2.dto;

import lombok.Data;

@Data
public class SignUpRequestDTO {

    private String nombre;
    private String apellidos;
    private String correo;
    private String username;
    private String password;
}
