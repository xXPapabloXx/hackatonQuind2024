package com.uco.hackathon.controller.torneo;


import com.uco.hackathon.domain.response.Response;
import com.uco.hackathon.domain.torneo.Torneo;
import com.uco.hackathon.service.torneo.TorneoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RestController
@RequestMapping("api/torneos")
public class TorneoControlador {

    @Autowired
    private TorneoServicio torneoServicio;

    private static final String NOT_VALID = "Not valid operation";
    private static final String SUCCESS = "Success";
    private static final String REMOVE = "remove";
    private static final String REPLACE = "replace";

    @PostMapping("/add")
    public ResponseEntity<Response<Torneo>> createTorneo(@Valid @RequestBody Torneo torneo, BindingResult result) {
        Response<Torneo> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.addMessage(error.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        if (torneoServicio.existsByNombre(torneo.getNombre())) {
            response.addMessage("El nombre del torneo ya existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        Torneo nuevoTorneo = torneoServicio.saveTorneo(torneo);
        response.setData(nuevoTorneo);
        response.addMessage("Torneo creado correctamente");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<Response<List<Torneo>>> listarTorneos() {
        List<Torneo> torneos = torneoServicio.listarTorneos();
        Response<List<Torneo>> response = new Response<>();
        response.setData(torneos);
        response.addMessage("Lista de torneos obtenida correctamente");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/edit/{nombre}")
    public ResponseEntity<Response<Torneo>> editarTorneo(@PathVariable String nombre, @Valid @RequestBody Torneo torneo) {
        torneo.setNombre(nombre);
        Torneo torneoActualizado = torneoServicio.actualizarTorneo(torneo);
        Response<Torneo> response = new Response<>();
        response.setData(torneoActualizado);
        response.addMessage("Torneo actualizado correctamente");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{nombreTorneo}")
    public ResponseEntity<String> eliminarTorneo(@PathVariable String nombreTorneo) {
        torneoServicio.eliminarTorneo(nombreTorneo);
        return ResponseEntity.ok("Torneo eliminado correctamente");
    }
}
