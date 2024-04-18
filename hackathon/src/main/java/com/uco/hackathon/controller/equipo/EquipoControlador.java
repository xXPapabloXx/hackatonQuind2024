package com.uco.hackathon.controller.equipo;

import com.uco.hackathon.domain.equipo.Equipo;
import com.uco.hackathon.service.equipo.EquipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.uco.hackathon.domain.response.Response;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RestController
@RequestMapping("api/equipos")
public class EquipoControlador {

    @Autowired
    private EquipoServicio equipoServicio;
    private static final String NOT_VALID="Not valid operation";
    private static final String SUCCESS="Success";
    private static final String REMOVE="remove";
    private static final String REPLACE="replace";


    @GetMapping("list")
    public ResponseEntity<Response<List<Equipo>>> listEquipos() {
        Response<List<Equipo>> response = new Response<>();
        List<Equipo> equipos = equipoServicio.getAllEquipos(); // Suponiendo que tienes un método en EquipoServicio para obtener todos los equipos
        response.setData(equipos);
        response.addMessage(SUCCESS);

        return ResponseEntity.ok(response);
    }

    @PostMapping("add/{nombreTorneo}")
    public ResponseEntity<Response<Equipo>> agregarEquipo(@PathVariable String nombreTorneo, @Valid @RequestBody Equipo equipo) {
        Response<Equipo> response = new Response<>();
        try {
            Equipo nuevoEquipo = equipoServicio.agregarEquipo(nombreTorneo, equipo);
            response.setData(nuevoEquipo);
            response.addMessage("Equipo añadido correctamente");
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException e) {
            response.addMessage("No se encontró un torneo con el nombre proporcionado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
