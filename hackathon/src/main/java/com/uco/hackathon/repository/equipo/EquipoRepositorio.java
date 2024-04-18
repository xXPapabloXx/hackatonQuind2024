package com.uco.hackathon.repository.equipo;

import com.uco.hackathon.domain.equipo.Equipo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepositorio extends CrudRepository<Equipo, String> {
}
