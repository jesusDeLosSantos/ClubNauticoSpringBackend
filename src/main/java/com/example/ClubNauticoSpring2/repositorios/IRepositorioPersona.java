package com.example.ClubNauticoSpring2.repositorios;

import com.example.ClubNauticoSpring2.modelos.Persona;
import org.springframework.data.repository.CrudRepository;


public interface IRepositorioPersona extends CrudRepository<Persona, Long> {
}