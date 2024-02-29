package com.example.ClubNauticoSpring2.controladores;

import com.example.ClubNauticoSpring2.dto.PersonaDTO;
import com.example.ClubNauticoSpring2.modelos.Persona;
import com.example.ClubNauticoSpring2.servicios.ServicioPersona;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v0/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorPersona {
    @Autowired
    private ServicioPersona servicioPersona;

    public ControladorPersona(ServicioPersona servicioPersona) {
        this.servicioPersona = servicioPersona;
    }



    @PostMapping
    public ResponseEntity<PersonaDTO> createPersona(@Valid @RequestBody PersonaDTO personaDTO){
        return new ResponseEntity<>(servicioPersona.createPersona(personaDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> getPersonas(){
        return ResponseEntity.ok(servicioPersona.getPersonas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> getPersonaPorId(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(servicioPersona.getPersonaPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> updatePersona(@Valid @RequestBody PersonaDTO personaDTO, @PathVariable(name = "id") Long id){
        PersonaDTO personaModificada = servicioPersona.updatePersona(personaDTO, id);
        return new ResponseEntity<>(personaModificada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersona(@PathVariable(name = "id") Long id){
        servicioPersona.deletePersona(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

