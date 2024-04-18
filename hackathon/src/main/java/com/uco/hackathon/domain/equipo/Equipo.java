package com.uco.hackathon.domain.equipo;

import com.uco.hackathon.domain.torneo.Torneo;
import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;


import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="equipo")
public class Equipo {


    @Id
    @Column(name="nombre")
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Column(name="descripcion")
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
    @Column(name="numerojugadores")
    @NotBlank(message = "El número de jugadores es obligatorio")
    private String numeroJugadores;

    @OneToMany(mappedBy = "equipo")
    private List<Torneo> torneo;

    public Equipo(){
        this.nombre = "";
        this.numeroJugadores = "";
        this.descripcion = "";
        this.torneo = new ArrayList<>();
    }
    public Equipo(String nombre, String numeroJugadores, String descripcion){
        this.nombre = nombre;
        this.numeroJugadores = numeroJugadores;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumeroJugadores() {
        return numeroJugadores;
    }

    public void setNumeroJugadores(String numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }


    public List<Torneo> getTorneo() {
        return torneo;
    }

    public void setTorneo(List<Torneo> torneo) {
        this.torneo = torneo;
    }
}
