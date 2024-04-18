package com.uco.hackathon.domain.equipo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uco.hackathon.domain.torneo.Torneo;
import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="equipo")
public class Equipo {


    @Id
    @Column(name="nombre")
    @NotNull(message = "El nombre es obligatorio")
    @NotBlank
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;
    @Column(name="numerojugadores")
    @NotNull(message = "El número de jugadores es obligatorio")
    @NotBlank
    private String numeroJugadores;



    @Column(name = "eliminado")
    private boolean eliminado;

    @Column(name = "fixture")
    private boolean fixture;


    public Equipo(){
        this.nombre = "";
        this.numeroJugadores = "";
        this.descripcion = "";
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


    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public boolean isFixture() {
        return fixture;
    }

    public void setFixture(boolean fixture) {
        this.fixture = fixture;
    }



}
