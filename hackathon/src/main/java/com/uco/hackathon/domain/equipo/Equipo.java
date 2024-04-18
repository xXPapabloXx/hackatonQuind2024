package com.uco.hackathon.domain.equipo;

import com.uco.hackathon.domain.torneo.Torneo;
import jakarta.persistence.*;



@Entity
@Table(name="equipo")
public class Equipo {
    @Id
    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;
    @Column(name="numerojugadores")
    private String numeroJugadores;

    @OneToMany
    @JoinColumn(name="torneoId")
    private Torneo torneo;

    public Equipo(){
        this.nombre = "";
        this.numeroJugadores = "";
        this.descripcion = "";
        this.torneo = new Torneo();
    }
    public Equipo(String nombre, String numeroJugadores, String descripcion){
        this.nombre = nombre;
        this.numeroJugadores = numeroJugadores;
        this.descripcion = descripcion;
    }

}
