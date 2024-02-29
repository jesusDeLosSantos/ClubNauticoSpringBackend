package com.example.ClubNauticoSpring2.servicios;

import com.example.ClubNauticoSpring2.repositorios.IRepositorioUsuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioUsuario implements IServicioUsuario{

	private final IRepositorioUsuario repositorioUsuario;

	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username){
				return repositorioUsuario.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
			}
		};
	}
}
