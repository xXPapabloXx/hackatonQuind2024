package com.uco.hackathon.repository.torneo;


import com.uco.hackathon.domain.equipo.Equipo;
import com.uco.hackathon.domain.torneo.Torneo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TorneoRepositorio extends CrudRepository<Torneo, String> {
    Optional<Torneo> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
