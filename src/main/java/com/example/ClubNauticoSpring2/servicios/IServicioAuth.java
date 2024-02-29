package com.example.ClubNauticoSpring2.servicios;


import com.example.ClubNauticoSpring2.dto.JWTAuthResponseDTO;
import com.example.ClubNauticoSpring2.dto.SignInRequestDTO;
import com.example.ClubNauticoSpring2.dto.SignUpRequestDTO;
import com.example.ClubNauticoSpring2.modelos.Usuario;

public interface IServicioAuth {

    public Usuario signup(SignUpRequestDTO signUpRequestDTO);
    public JWTAuthResponseDTO signin(SignInRequestDTO signInRequestDTO);
}
