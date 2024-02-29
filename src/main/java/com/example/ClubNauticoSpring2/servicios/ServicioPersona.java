package com.example.ClubNauticoSpring2.servicios;

import com.example.ClubNauticoSpring2.dto.PersonaDTO;
import com.example.ClubNauticoSpring2.excepciones.RecursoBorradoException;
import com.example.ClubNauticoSpring2.excepciones.RecursoNoEncontradoException;
import com.example.ClubNauticoSpring2.modelos.Persona;
import com.example.ClubNauticoSpring2.repositorios.IRepositorioPersona;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ServicioPersona implements IServicioPersona {

    private IRepositorioPersona repositorioPersona;
    @Autowired
    private ModelMapper modelMapper;

    public ServicioPersona(IRepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public PersonaDTO mappearPersonaDTO(Persona persona){
        return modelMapper.map(persona, PersonaDTO.class);
    }

    private Persona mappearPersona(PersonaDTO personaDTO) {
        return modelMapper.map(personaDTO, Persona.class);
    }

    @Override
    public PersonaDTO createPersona(PersonaDTO personaDTO) {
        Persona nuevaPersona = repositorioPersona.save(mappearPersona(personaDTO));
        return mappearPersonaDTO(nuevaPersona);
    }

    @Override
    public List<PersonaDTO> getPersonas() {
        List<PersonaDTO> personas = new ArrayList<PersonaDTO>();
        repositorioPersona.findAll().forEach(p -> personas.add(mappearPersonaDTO(p)));
        return personas;
    }

    @Override
    public PersonaDTO getPersonaPorId(Long id) {
        return mappearPersonaDTO(repositorioPersona.findById(id).orElseThrow(()->new RecursoNoEncontradoException("Persona", "id", id.toString())));
    }

    @Override
    public PersonaDTO updatePersona(PersonaDTO personaDTO, Long id) {
        Persona persona = repositorioPersona.findById(id).orElseThrow(()->new RecursoNoEncontradoException("Persona", "id", id.toString()));
        personaDTO.setId(persona.getId());
        Persona personaModificada = repositorioPersona.save(mappearPersona(personaDTO));
        return mappearPersonaDTO(personaModificada);
    }

    @Override
    public void deletePersona(Long id) {
        Persona persona = repositorioPersona.findById(id).orElseThrow(()->new RecursoBorradoException("Persona", "id", id.toString()));
        if(Objects.equals(persona.getId(), id)) {
            repositorioPersona.deleteById(id);
        }
    }
}
