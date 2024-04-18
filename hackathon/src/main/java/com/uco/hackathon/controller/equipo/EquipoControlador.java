package com.uco.hackathon.controller.equipo;

import com.uco.hackathon.domain.equipo.Equipo;
import com.uco.hackathon.service.equipo.EquipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.uco.hackathon.domain.response.Response;

import java.util.List;

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

    @PostMapping("add")
    public ResponseEntity<Response<Equipo>> createBudget(@RequestBody Equipo equipo) {
        Response<Equipo> response = new Response<>();
        ResponseEntity<Response<Equipo>> responseEntity;
        HttpStatus status = HttpStatus.OK;
        try {

            Equipo respuestaEquipo = EquipoServicio.save(equipo);
            response.setData(respuestaEquipo);
            response.addMessage(SUCCESS);
        } catch (Exception e) {
            response.addMessage(e.getMessage());
            status = HttpStatus.BAD_REQUEST;
        }
        responseEntity = new ResponseEntity<>(response, status);
        return responseEntity;
    }

}
