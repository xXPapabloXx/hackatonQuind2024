package com.uco.hackathon.repository.torneo;


import com.uco.hackathon.domain.torneo.Torneo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneoRepositorio extends CrudRepository<Torneo, String> {
}
