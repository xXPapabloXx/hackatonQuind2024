package com.uco.hackathon.service.equipo;

import com.uco.hackathon.domain.equipo.Equipo;
import com.uco.hackathon.repository.equipo.EquipoRepositorio;
import com.uco.hackathon.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoServicio {

    private static EquipoRepositorio equipoRepositorio;
    @Autowired
    public EquipoServicio( EquipoRepositorio equipoRepositorio){
        this.equipoRepositorio = equipoRepositorio;
    }

    public static Equipo save(Equipo equipo){
        Optional<Equipo> equipoExistente = equipoRepositorio.findByNombre(equipo.getNombre());
        if(equipoExistente.isPresent()){
            throw new CustomException("El equipo ya existe!!");
        }else{
            Equipo equipoGuardado =equipoRepositorio.save(equipo);
            return equipoGuardado;
        }
    }

    public List<Equipo> getAllEquipos() {
        return (List<Equipo>) equipoRepositorio.findAll();
    }

}
