package com.uco.hackathon.domain.torneo;

import com.uco.hackathon.domain.equipo.Equipo;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="torneo")
public class Torneo {

    @Id
    @Column(name = "nombre")
    @NotNull(message = "El nombre es obligatorio")
    private String nombre;


    @Column(name = "ubicacion")
    @NotNull(message = "La ubicación es obligatoria")
    private String ubicacion;


    @Column(name = "deporte")
    @NotNull(message = "El deporte es obligatorio")
    private String deporte;


    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "equipo_nombre")
    private Equipo equipo;

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

}
