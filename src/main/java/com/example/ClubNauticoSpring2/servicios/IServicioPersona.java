package com.example.ClubNauticoSpring2.servicios;

import com.example.ClubNauticoSpring2.dto.PersonaDTO;
import com.example.ClubNauticoSpring2.modelos.Persona;
import java.util.List;

public interface IServicioPersona{
    List<PersonaDTO> getPersonas();
    PersonaDTO getPersonaPorId(Long id);
    PersonaDTO createPersona(PersonaDTO persona);
    PersonaDTO updatePersona(PersonaDTO persona, Long id);
    void deletePersona(Long id);
}
