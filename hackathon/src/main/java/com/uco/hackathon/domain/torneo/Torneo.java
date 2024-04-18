package com.uco.hackathon.domain.torneo;

import com.uco.hackathon.domain.equipo.Equipo;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="torneo")
public class Torneo {

    @Id
    @Column(name = "nombre")
    @NotNull(message = "El nombre es obligatorio")
    @NotBlank
    private String nombre;


    @Column(name = "ubicacion")
    @NotNull(message = "La ubicación es obligatoria")
    @NotBlank
    private String ubicacion;


    @Column(name = "deporte")
    @NotNull(message = "El deporte es obligatorio")
    @NotBlank
    private String deporte;


    @Column(name = "descripcion")
    private String descripcion;



    @Column(name = "eliminado")
    private boolean eliminado;



    @Column(name = "fixture")
    private boolean fixture;

    @ManyToMany
    @JoinTable(
            name = "equipo_torneo",
            joinColumns = @JoinColumn(name = "torneo_nombre"),
            inverseJoinColumns = @JoinColumn(name = "equipo_nombre")
    )
    private List<Equipo> equipo = new ArrayList<>();

   public Torneo(){
        this.nombre = "";
        this.ubicacion = "";
        this.deporte = "";
        this.descripcion = "";
   }

   public Torneo(String nombre, String ubicacion, String deporte, String descripcion){
       this.nombre = nombre;
       this.ubicacion = ubicacion;
       this.deporte = deporte;
       this.descripcion = descripcion;
   }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Equipo> getEquipos() {
        return equipo;
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
