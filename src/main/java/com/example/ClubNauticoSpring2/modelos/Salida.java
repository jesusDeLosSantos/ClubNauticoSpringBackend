package com.example.ClubNauticoSpring2.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table (name = "SALIDA")
public class Salida implements Serializable {

    //Atributos
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private Long id;
    @Column (name = "FECHA_SALIDA")
    private String fechaSalida;
    @Column (name = "FECHA_ENTRADA")
    private String fechaEntrada;
    @Column (name = "DESTINO")
    private String destino;
    @JoinColumn(name = "ID_PERSONA")
    private Long patron;
    @JoinColumn(name = "ID_BARCO")
    private Long barco;

    //Constructores
    public Salida() {
    }

    public Salida(Long id, String fechaSalida, String fechaEntrada, String destino, Long patron, Long barco) {
        this.id = id;
        this.fechaSalida = fechaSalida;
        this.fechaEntrada = fechaEntrada;
        this.destino = destino;
        this.patron = patron;
        this.barco = barco;
    }

    @Override
    public String toString() {
        return "Salida{" +
                "id=" + id +
                ", fechaSalida=" + fechaSalida +
                ", fechaEntrada=" + fechaEntrada +
                ", destino='" + destino + '\'' +
                '}';
    }
}
