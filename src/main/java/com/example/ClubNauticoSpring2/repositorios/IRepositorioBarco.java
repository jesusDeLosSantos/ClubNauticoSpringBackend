package com.example.ClubNauticoSpring2.repositorios;

import com.example.ClubNauticoSpring2.modelos.Barco;
import org.springframework.data.repository.CrudRepository;

public interface IRepositorioBarco extends CrudRepository<Barco, Long> {
}
