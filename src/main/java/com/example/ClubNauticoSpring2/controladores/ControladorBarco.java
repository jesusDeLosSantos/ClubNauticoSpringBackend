package com.example.ClubNauticoSpring2.controladores;

import com.example.ClubNauticoSpring2.dto.BarcoDTO;
import com.example.ClubNauticoSpring2.servicios.IServicioBarco;
import com.example.ClubNauticoSpring2.servicios.ServicioBarco;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v0/barcos")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorBarco {
    @Autowired
    private IServicioBarco servicioBarco;

    public ControladorBarco(ServicioBarco servicioBarco) {
        this.servicioBarco = servicioBarco;
    }


    @GetMapping
    public ResponseEntity<List<BarcoDTO>> getBarcos(){
        return ResponseEntity.ok(servicioBarco.getBarcos());
    }

    @PostMapping
    public ResponseEntity<BarcoDTO> createBarco(@Valid @RequestBody BarcoDTO barcoDTO){
        return new ResponseEntity<>(servicioBarco.createBarco(barcoDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarcoDTO> getBarcoPorId(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(servicioBarco.getBarcoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BarcoDTO> updateBarco(@Valid @RequestBody BarcoDTO barcoDTO, @PathVariable(name = "id") Long id){
        BarcoDTO barcoMod = servicioBarco.updateBarco(barcoDTO, id);
        return new ResponseEntity<>(barcoMod, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBarco(@PathVariable(name = "id") Long id){
        servicioBarco.deleteBarco(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

