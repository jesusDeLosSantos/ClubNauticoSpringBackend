package com.example.ClubNauticoSpring2.dto;

//import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class SalidaDTO implements Serializable {

    @NotNull
    @Positive
    private Long id;
    @NotEmpty
    private String destino;
    @NotEmpty
    private String fecha;
    @NotEmpty
    private String hora;
    @NotNull
    @Positive
    private Long idPatron;
    @NotNull
    @Positive
    private Long idBarco;

    public SalidaDTO(Long id, String destino, String fecha, String hora, Long idPatron, Long idBarco) {
        this.id = id;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.idPatron = idPatron;
        this.idBarco = idBarco;
    }




}
