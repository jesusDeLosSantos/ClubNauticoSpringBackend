package com.example.ClubNauticoSpring2.repositorios;

import com.example.ClubNauticoSpring2.modelos.Salida;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepositorioSalida extends CrudRepository<Salida, Long> {
//    public List<Salida> getPorIdBarco(Long barcoId);
//    public List<Salida> getPorIdPatron(Long patronId);
}
