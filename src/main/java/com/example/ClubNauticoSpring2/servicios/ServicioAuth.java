package com.example.ClubNauticoSpring2.servicios;

import java.util.HashMap;

import com.example.ClubNauticoSpring2.dto.JWTAuthResponseDTO;
import com.example.ClubNauticoSpring2.dto.SignInRequestDTO;
import com.example.ClubNauticoSpring2.dto.SignUpRequestDTO;
import com.example.ClubNauticoSpring2.modelos.Rol;
import com.example.ClubNauticoSpring2.modelos.Usuario;
import com.example.ClubNauticoSpring2.repositorios.IRepositorioUsuario;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioAuth implements IServicioAuth{

	private final IRepositorioUsuario repositorioUsuario;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final ServicioJWT servicioJWT;

	public Usuario signup(SignUpRequestDTO signUpRequestDTO) {
		Usuario usuario = new Usuario();

		usuario.setNombre(signUpRequestDTO.getNombre());
		usuario.setApellidos(signUpRequestDTO.getApellidos());
		usuario.setUsername(signUpRequestDTO.getUsername());
		usuario.setCorreo(signUpRequestDTO.getCorreo());
		usuario.setRol(Rol.USER);
		usuario.setPassword(passwordEncoder.encode(signUpRequestDTO.getPassword()));

		return repositorioUsuario.save(usuario);
	}

	public JWTAuthResponseDTO signin(SignInRequestDTO signInRequestDTO) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						signInRequestDTO.getUsername(),
						signInRequestDTO.getPassword()));
		var usuario = repositorioUsuario.findByUsername(signInRequestDTO.getUsername())
				.orElseThrow(()->new IllegalArgumentException("Usuario o contraseña incorrectos / no existen"));
		var jwt = servicioJWT.generateToken(usuario);
		var refreshToken = servicioJWT.generateRefreshToken(new HashMap<>(), usuario);

		JWTAuthResponseDTO jwtAuthResponseDTO = new JWTAuthResponseDTO();

		jwtAuthResponseDTO.setToken(jwt);
		jwtAuthResponseDTO.setRefreshToken(refreshToken);
		return jwtAuthResponseDTO;
	}
}
