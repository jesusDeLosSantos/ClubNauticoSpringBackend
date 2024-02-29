package com.example.ClubNauticoSpring2.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table (name = "BARCO")
public class Barco implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private Long id;
    @Column (name = "MATRICULA")
    private String matricula;
    @Column (name = "NOMBRE")
    private String nombre;
    @Column (name = "NUMERO_AMARRE")
    private String numeroAmarre;
    @Column (name = "CUOTA")
    private double cuota;
    @OneToMany(mappedBy = "barco", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Salida> salidas;
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_SOCIO")
    private Persona dueno;

    //Constructores
    public Barco() {
    }

    public Barco(Long id, String matricula, String nombre, String numeroAmarre, double cuota, Persona dueno) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.numeroAmarre = numeroAmarre;
        this.cuota = cuota;
        this.dueno = dueno;
    }
}
