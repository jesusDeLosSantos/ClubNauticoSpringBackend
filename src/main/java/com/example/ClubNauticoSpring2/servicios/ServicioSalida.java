package com.example.ClubNauticoSpring2.servicios;


import java.util.ArrayList;
import java.util.stream.Collectors;

import com.example.ClubNauticoSpring2.dto.SalidaDTO;
import com.example.ClubNauticoSpring2.excepciones.NoPatronException;
import com.example.ClubNauticoSpring2.excepciones.RecursoBorradoException;
import com.example.ClubNauticoSpring2.excepciones.RecursoNoEncontradoException;
import com.example.ClubNauticoSpring2.modelos.Barco;
import com.example.ClubNauticoSpring2.modelos.Persona;
import com.example.ClubNauticoSpring2.modelos.Salida;
import com.example.ClubNauticoSpring2.repositorios.IRepositorioBarco;
import com.example.ClubNauticoSpring2.repositorios.IRepositorioPersona;
import com.example.ClubNauticoSpring2.repositorios.IRepositorioSalida;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ServicioSalida implements IServicioSalida{

    @Autowired
    private IRepositorioSalida salidaDao;
    @Autowired
    private IRepositorioBarco barcoDao;
    @Autowired
    private IRepositorioPersona personaDao;
    @Autowired
    private ModelMapper modelMapper;

    private SalidaDTO mapToDTO(Salida salida) {
        SalidaDTO salidaDTO = modelMapper.map(salida, SalidaDTO.class);
        return salidaDTO;
    }

    private Salida mapToEntity(SalidaDTO salidaDTO) {
        Salida salida = modelMapper.map(salidaDTO, Salida.class);
        return salida;
    }



    @Override
    public SalidaDTO createSalida(Long barcoId, Long patronId, SalidaDTO salidaDTO) {
        Salida salida = mapToEntity(salidaDTO);
        Barco barco = barcoDao.findById(barcoId)
                .orElseThrow(()-> new RecursoNoEncontradoException("Barco", "id", barcoId.toString()));
        Persona persona = personaDao.findById(patronId)
                .orElseThrow(()-> new RecursoNoEncontradoException("Persona", "id", patronId.toString()));
        if(!persona.isPatron()) {
            throw new NoPatronException("Persona", "id", persona.getId().toString());
        }
        salida.setBarco(barco.getId());
        salida.setPatron(persona.getId());
        Salida nuevaSalida = salidaDao.save(salida);
        return mapToDTO(nuevaSalida);
    }

    @Override
    public List<SalidaDTO> getSalidas() {
        List<SalidaDTO> salidas = new ArrayList<SalidaDTO>();
        salidaDao.findAll().forEach(s -> salidas.add(mapToDTO(s)));
        return salidas;
    }

    @Override
    public SalidaDTO getSalidaPorId(Long id) {
        return mapToDTO(salidaDao.findById(id).orElseThrow(()->new RecursoNoEncontradoException("Salida", "id", id.toString())));
    }

//    @Override
//    public List<SalidaDTO> getSalidasPorIdBarco(Long barcoId) {
//        List<Salida> salidas = salidaDao.getPorIdBarco(barcoId);
//        return salidas.stream().map(s -> mapToDTO(s)).collect(Collectors.toList());
//    }
//
//    @Override
//    public List<SalidaDTO> getSalidasPorIdPatron(Long patronId) {
//        List<Salida> salidas = salidaDao.getPorIdPatron(patronId);
//        return salidas.stream().map(s -> mapToDTO(s)).collect(Collectors.toList());
//    }

    @Override
    public SalidaDTO updateSalida(SalidaDTO salidaDTO, Long id) {
        Salida salida = salidaDao.findById(id).orElseThrow(()->new RecursoNoEncontradoException("Salida", "id", id.toString()));
        if(!personaDao.findById(salidaDTO.getIdPatron()).get().isPatron()) {
            throw new NoPatronException("Persona", "id", salidaDTO.getIdPatron().toString());
        }
        salidaDTO.setId(salida.getId());
        Salida salidaModificada = salidaDao.save(mapToEntity(salidaDTO));
        return mapToDTO(salidaModificada);
    }

    @Override
    public void deleteSalida(Long id) {
        Salida salida = salidaDao.findById(id).orElseThrow(()->new RecursoBorradoException("Salida", "id", id.toString()));
        if(salida.getId() == id) {
            salidaDao.deleteById(id);
        }
    }

}
