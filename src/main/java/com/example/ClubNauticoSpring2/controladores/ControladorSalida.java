package com.example.ClubNauticoSpring2.controladores;

import com.example.ClubNauticoSpring2.dto.SalidaDTO;
import com.example.ClubNauticoSpring2.servicios.IServicioSalida;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v0/salidas")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorSalida {

    @Autowired
    private IServicioSalida servicioSalida;

    @PostMapping
    public ResponseEntity<SalidaDTO> crearSalida(@RequestBody SalidaDTO salidaDTO) {
        return new ResponseEntity<>(servicioSalida.createSalida(salidaDTO.getIdBarco(), salidaDTO.getIdPatron(), salidaDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SalidaDTO>> getSalidas() {
        return ResponseEntity.ok(servicioSalida.getSalidas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalidaDTO> getSalidaPorId(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(servicioSalida.getSalidaPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalidaDTO> updateSalida(@Valid @RequestBody SalidaDTO salidaDTO, @PathVariable(name = "id") Long id) {
        SalidaDTO salidaModificada = servicioSalida.updateSalida(salidaDTO, id);
        return new ResponseEntity<>(salidaModificada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSalida(@PathVariable(name = "id") Long id) {
        servicioSalida.deleteSalida(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
