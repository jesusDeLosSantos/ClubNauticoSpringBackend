package com.example.ClubNauticoSpring2.servicios;

import com.example.ClubNauticoSpring2.dto.SalidaDTO;

import java.util.List;

public interface IServicioSalida {
    List<SalidaDTO> getSalidas();
    SalidaDTO getSalidaPorId(Long id);
    //public List<SalidaDTO> getSalidasPorIdBarco(Long barcoId);
    //public List<SalidaDTO> getSalidasPorIdPatron(Long patronId);
    SalidaDTO createSalida(Long barcoId, Long patronId, SalidaDTO salidaDTO);
    SalidaDTO updateSalida(SalidaDTO salida, Long id);
    void deleteSalida(Long id);
}
