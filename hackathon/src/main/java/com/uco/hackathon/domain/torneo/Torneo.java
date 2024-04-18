package com.uco.hackathon.domain.torneo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="torneo")
public class Torneo {

    @Id
   @Column(name="nombre")
   private String nombre;
   @Column(name="ubicacion")
    private String ubicacion;
   @Column(name="deporte")
    private String deporte;
   @Column(name = "descripcion")
    private String descripcion;

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
