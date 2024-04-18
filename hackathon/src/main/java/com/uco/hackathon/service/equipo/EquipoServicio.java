package com.uco.hackathon.service.equipo;

import com.uco.hackathon.domain.equipo.Equipo;
import com.uco.hackathon.domain.torneo.Torneo;
import com.uco.hackathon.repository.equipo.EquipoRepositorio;
import com.uco.hackathon.repository.torneo.TorneoRepositorio;
import com.uco.hackathon.util.CustomException;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EquipoServicio {

    private static EquipoRepositorio equipoRepositorio;
    @Autowired
    public EquipoServicio( EquipoRepositorio equipoRepositorio){
        this.equipoRepositorio = equipoRepositorio;
    }
    @Autowired
    private TorneoRepositorio torneoRepositorio;

    public static Equipo save(Equipo equipo){
        Optional<Equipo> equipoExistente = equipoRepositorio.findByNombre(equipo.getNombre());
        if(equipoExistente.isPresent()){
            throw new CustomException("El equipo ya existe!!");
        }else{
            Equipo equipoGuardado =equipoRepositorio.save(equipo);
            return equipoGuardado;
        }
    }

    public Equipo agregarEquipo(String nombreTorneo, Equipo equipo) {
        try {
            Torneo torneo = torneoRepositorio.findByNombre(nombreTorneo).orElseThrow(() -> new NoSuchElementException("No se encontró un torneo con el nombre proporcionado"));
            //Que el equipo no exista en el torneo
            if (torneo.getEquipos().stream().anyMatch(e -> e.getNombre().equals(equipo.getNombre()))) {
                throw new CustomException("El equipo ya está inscrito en el torneo");
            }


            torneo.getEquipos().add(equipo);
            equipoRepositorio.save(equipo);
            torneoRepositorio.save(torneo);

        }catch(Exception e){
            throw new CustomException("Falló creacion equipo",e);
        }

        return equipo;
    }

    public List<Equipo> getAllEquipos() {
        return (List<Equipo>) equipoRepositorio.findAll();
    }

    public Equipo guardarEquipo(Equipo equipo) {
        return equipoRepositorio.save(equipo);
    }

    public Equipo buscarPorNombre(String nombreEquipo) {
        return equipoRepositorio.findByNombre(nombreEquipo)
                .orElseThrow(() -> new NoSuchElementException("No se encontró un equipo con el nombre proporcionado"));
    }

    public void eliminarEquipo(String nombreEquipo) {
        Equipo equipo = buscarPorNombre(nombreEquipo);
        equipo.setEliminado(true);
        equipoRepositorio.save(equipo);
    }

}
