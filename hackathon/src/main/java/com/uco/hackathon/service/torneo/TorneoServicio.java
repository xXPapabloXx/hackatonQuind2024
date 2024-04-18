package com.uco.hackathon.service.torneo;

import com.uco.hackathon.domain.equipo.Equipo;
import com.uco.hackathon.domain.torneo.Torneo;
import com.uco.hackathon.repository.torneo.TorneoRepositorio;
import com.uco.hackathon.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TorneoServicio {

    @Autowired
    private TorneoRepositorio torneoRepositorio;

    public boolean existsByNombre(String nombre) {
        return torneoRepositorio.existsByNombre(nombre);
    }

    public Torneo saveTorneo(Torneo torneo) {
        return torneoRepositorio.save(torneo);
    }

    public List<Torneo> listarTorneos() {
        return (List<Torneo>) torneoRepositorio.findAll();
    }

    public Torneo actualizarTorneo(Torneo torneo) {
        if (torneo.getNombre() == null || torneo.getUbicacion() == null || torneo.getDeporte() == null || torneo.getDescripcion() == null) {
            throw new CustomException("Todos los campos son obligatorios para actualizar un torneo");
        }

        if (!torneoRepositorio.existsById(torneo.getNombre())) {
            throw new CustomException("No se encontró un torneo con el nombre proporcionado");
        }

        return torneoRepositorio.save(torneo);
    }

    public Torneo buscarPorNombre(String nombreTorneo) {
        return torneoRepositorio.findByNombre(nombreTorneo)
                .orElseThrow(() -> new NoSuchElementException("No se encontró un equipo con el nombre proporcionado"));
    }

    public void eliminarTorneo(String nombreTorneo) {
        Torneo torneo = buscarPorNombre(nombreTorneo);
        torneo.setEliminado(true);
        torneoRepositorio.save(torneo);
    }

}
