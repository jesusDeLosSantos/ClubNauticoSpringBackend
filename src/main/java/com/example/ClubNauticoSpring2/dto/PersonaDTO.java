package com.example.ClubNauticoSpring2.dto;

//import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class PersonaDTO implements Serializable {

    //@NotEmpty
    //@Positive
    private Long id;
    //@NotEmpty
    private String dni;
   // @NotEmpty
    private String nombre;
   // @NotEmpty
    private String apellidos;
   // @NotEmpty
    private String correo;
   // @NotEmpty
    private String telefono;
   // @NotNull
    private Boolean socio;
   // @NotNull
    private Boolean patron;


    public PersonaDTO(String dni, Long id, String nombre, String apellidos, String correo, String telefono, boolean socio, boolean patron) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.socio = socio;
        this.patron = patron;
    }

    public PersonaDTO(String dni, String nombre, String apellidos, String correo, String telefono, boolean socio, boolean patron) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.socio = socio;
        this.patron = patron;
    }
}
