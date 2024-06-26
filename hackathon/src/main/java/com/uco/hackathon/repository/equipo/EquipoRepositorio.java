package com.uco.hackathon.repository.equipo;

import com.uco.hackathon.domain.equipo.Equipo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipoRepositorio extends CrudRepository<Equipo, String> {
    Optional<Equipo> findByNombre(String nombre);
    Optional<Equipo> findByNombreAndEliminadoFalse(String nombre);
}
