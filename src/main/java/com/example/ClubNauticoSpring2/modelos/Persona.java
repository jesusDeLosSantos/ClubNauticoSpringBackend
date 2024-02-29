package com.example.ClubNauticoSpring2.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table (name = "PERSONA")
public class Persona implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DNI")
    private String dni;
    @Column (name = "NOMBRE")
    private String nombre;
    @Column (name = "APELLIDOS")
    private String apellidos;
    @Column (name = "CORREO")
    private String correo;
    @Column (name = "TELEFONO")
    private String telefono;
    @Column (name = "SOCIO")
    private boolean socio;
    @Column (name = "PATRON")
    private boolean patron;
//    @OneToMany(mappedBy = "patron", cascade = CascadeType.ALL)
//    private List<Salida> salidas;


    //Constructores
    public Persona() {
    }

    public Persona(Long id, String dni, String nombre, String apellidos, String correo, String telefono, boolean socio, boolean patron) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.socio = socio;
        this.patron = patron;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
