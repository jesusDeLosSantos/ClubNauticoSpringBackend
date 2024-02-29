package com.example.ClubNauticoSpring2.servicios;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface IServicioUsuario {

	public UserDetailsService userDetailsService();
}
