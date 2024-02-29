package com.example.ClubNauticoSpring2.dto;

//import jakarta.validation.constraints.NotNull;
import com.example.ClubNauticoSpring2.modelos.Persona;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class BarcoDTO implements Serializable {

    @Positive
    private Long id;
    @Pattern(regexp="[0-9]{4}[A-Z]{3}")
    private String matricula;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String numeroAmarre;
    @NotNull
    @Positive
    private Integer cuota;
    @NotNull
    private Persona dueno;


    public BarcoDTO(Long id, String matricula, String nombre, String numeroAmarre, Integer cuota, Persona dueno) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.numeroAmarre = numeroAmarre;
        this.cuota = cuota;
        this.dueno = dueno;
    }
}
