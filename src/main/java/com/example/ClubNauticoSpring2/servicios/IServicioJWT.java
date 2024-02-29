package com.example.ClubNauticoSpring2.servicios;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface IServicioJWT {

	public String extractUsername(String token);
	public String generateToken(UserDetails userDetails);
	public boolean isTokenValid(String token, UserDetails userDetails);
	public String generateRefreshToken(Map<String, Object> hashMap, UserDetails userDetails);
}
