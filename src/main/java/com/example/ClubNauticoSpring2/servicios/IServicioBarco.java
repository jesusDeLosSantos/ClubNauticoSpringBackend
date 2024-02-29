package com.example.ClubNauticoSpring2.servicios;

import com.example.ClubNauticoSpring2.dto.BarcoDTO;
import com.example.ClubNauticoSpring2.modelos.Barco;

import java.util.List;

public interface IServicioBarco {
    List<BarcoDTO> getBarcos();
    BarcoDTO getBarcoPorId(Long id);
    BarcoDTO createBarco(BarcoDTO barco);
    BarcoDTO updateBarco(BarcoDTO barco, Long id);
    void deleteBarco(Long id);
}
