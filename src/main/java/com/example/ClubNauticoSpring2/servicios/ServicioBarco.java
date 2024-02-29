package com.example.ClubNauticoSpring2.servicios;

import com.example.ClubNauticoSpring2.dto.BarcoDTO;
import com.example.ClubNauticoSpring2.excepciones.RecursoBorradoException;
import com.example.ClubNauticoSpring2.excepciones.RecursoNoEncontradoException;
import com.example.ClubNauticoSpring2.modelos.Barco;
import com.example.ClubNauticoSpring2.repositorios.IRepositorioBarco;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ServicioBarco implements IServicioBarco {

    private IRepositorioBarco repositorioBarco;

    public ServicioBarco(IRepositorioBarco repositorioBarco) {
        this.repositorioBarco = repositorioBarco;
    }

    public BarcoDTO mappearBarcoDTO(Barco barco){
        BarcoDTO barcoDTO = new BarcoDTO();
        barcoDTO.setId(barco.getId());
        barcoDTO.setMatricula(barco.getMatricula());
        barcoDTO.setNombre(barco.getNombre());
        return barcoDTO;
    }

    private Barco mappearBarco(BarcoDTO barcoDTO) {
        Barco barco = new Barco();
        barco.setId(barcoDTO.getId());
        barco.setMatricula(barcoDTO.getMatricula());
        barco.setNombre(barcoDTO.getNombre());
        barco.setDueno(barcoDTO.getDueno());
        barco.setCuota(barcoDTO.getCuota());
        return barco;
    }

    @Override
    public List<BarcoDTO> getBarcos() {
        List<BarcoDTO> barcosDTO = new ArrayList<BarcoDTO>();
        repositorioBarco.findAll().forEach(b -> barcosDTO.add(mappearBarcoDTO(b)));
        return barcosDTO;
    }
    @Override
    public BarcoDTO createBarco(BarcoDTO barcoDTO) {
        Barco barco = mappearBarco(barcoDTO);
        Barco nuevoBarco = repositorioBarco.save(barco);
        return mappearBarcoDTO(nuevoBarco);
    }

    @Override
    public BarcoDTO getBarcoPorId(Long id) {
        return mappearBarcoDTO(repositorioBarco.findById(id).get());
    }

    @Override
    public BarcoDTO updateBarco(BarcoDTO barcoDTO, Long id) {
        Barco barco = repositorioBarco.findById(id).orElseThrow(()->new RecursoNoEncontradoException("Barco", "id", id.toString()));
        barco.setNumeroAmarre(barcoDTO.getNumeroAmarre());
        barco.setCuota(barcoDTO.getCuota());
        barco.setMatricula(barcoDTO.getMatricula());
        barco.setNombre(barcoDTO.getNombre());
        barco.setDueno(barcoDTO.getDueno());

        Barco barcoModificado = repositorioBarco.save(barco);
        return mappearBarcoDTO(barcoModificado);
    }

    @Override
    public void deleteBarco(Long id) {
        Barco barco = repositorioBarco.findById(id).orElseThrow(()->new RecursoBorradoException("Barco", "id", id.toString()));
        if(Objects.equals(barco.getId(), id)) {
            repositorioBarco.deleteById(id);
        }
    }
}
